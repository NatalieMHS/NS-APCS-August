/* Natalie Suboc
 * November 13, 2017
 * Fraction calculator that takes two fractions and
 * 
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	String quit = "";
    	do {
    		String expression = input.nextLine();
    		if (expression.equals("quit")) {
    			break;
    		}
    		System.out.println(produceAnswer(expression));
    	} while (true);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
        String[] splitExpr = input.split(" ");
        String firstFrac = splitExpr[0];
        String operand = splitExpr[1];
        String secFrac = splitExpr[2];
        
        String[] splitFrac1 = parseFrac(firstFrac); 
        String[] splitFrac2 = parseFrac(secFrac);
        int[] fracNums1 = new int[3]; 
        int[] fracNums2 = new int[3];
        
        for (int i = 0; i < splitFrac1.length; i++) {
        	fracNums1[i] = Integer.parseInt(splitFrac1[i]);
        	fracNums2[i] = Integer.parseInt(splitFrac2[i]);
        }
        
        int[] impFrac1 = toImproperFrac(fracNums1[0], fracNums1[1], fracNums1[2]);
        int[] impFrac2 = toImproperFrac(fracNums2[0], fracNums2[1], fracNums2[2]);
        System.out.println(Arrays.toString(impFrac1) + " " + Arrays.toString(impFrac2));
        if (operand.equals("/") || operand.equals("*")) {
        	// return multiplyOrDivide(fracNums1, operand, fracNums2);
        } else if (operand.equals("+") || operand.equals("-")) {
        	System.out.println(addOrSubtract(impFrac1, operand, impFrac2));
        } else {
        	// return "Not a valid operator";
        }
        
        return "whole:"+ splitFrac2[0] + " numerator:" + splitFrac2[1] + " denominator:" + splitFrac2[2];
    }

    // takes a fraction and returns the whole number, numerator, and denominator of it
    public static String[] parseFrac(String fraction) {
    	String whole = "0";
    	String denom = "1";
    	String numer = "0";
    	if (fraction.contains("_")) {
    		String[] splitFrac = fraction.split("_");
    		whole = splitFrac[0];
    		fraction = splitFrac[1];
    	}
    	if (fraction.contains("/")) {
    		String[] splitFrac2 = fraction.split("/");
    		numer = splitFrac2[0];
    		denom = splitFrac2[1];
    	}
    	if (!(fraction.contains("_")) && !(fraction.contains("/"))) {
    		whole = fraction;
    	}
    	String[] parsedFrac = {whole, numer, denom};
    	return parsedFrac;
    	
    }
    
    // changes a mixed number to an improper fraction
	public static int[] toImproperFrac(int wholeNum, int numerator, int denominator) {
		int improper = (wholeNum * denominator);
		if (numerator < 0 || denominator < 0) {
			throw new IllegalArgumentException("The numerator or denominator of a mixed number cannot be negative.");
		}
		if (wholeNum >= 0) {
			improper += numerator;
		} else {
			improper -= numerator;
		}
		int[] impFrac = {improper, denominator};
		return impFrac;
	}
	public static String addOrSubtract(int[] frac1, String operand, int[] frac2) {
		int comDenom = frac1[1] * frac2[1];
		System.out.println(comDenom);
		frac1[0] *= frac2[1];
		frac2[0] *= frac1[1];
		int numer = 0;
		if (operand.equals("-")) {
			numer = frac1[0] - frac2[0];
		}
		if (operand.equals("+")) {
			numer = frac1[0] + frac2[0];
		}
		System.out.println(numer);
		return numer + "/" + comDenom;
	}
}
