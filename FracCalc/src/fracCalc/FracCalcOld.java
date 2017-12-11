/* Natalie Suboc
 * November 13, 2017
 * Fraction calculator that takes two fractions and
 * performs an operation (addition, subtraction, multiplication,
 * or division) on them
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalcOld {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
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

    	String[] splitExpr = input.split(" ");
        String firstFrac = splitExpr[0];
        String operator = splitExpr[1];
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
        int[] result = new int[2];
        if (operator.equals("/") || operator.equals("*")) {
        	result = multiplyOrDivide(impFrac1, operator, impFrac2);
        	return reduceFrac(result[0], result[1]);
        } else if (operator.equals("+") || operator.equals("-")) {
        	result = addOrSubtract(impFrac1, operator, impFrac2);
        	return reduceFrac(result[0], result[1]);
        } else {
        	return "ERROR: Not a valid operator.";
        }
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
		if (wholeNum >= 0) {
			improper += numerator;
		} else {
			improper -= numerator;
		}
		int[] impFrac = {improper, denominator};
		return impFrac;
	}
	
	// checks to see if a number is divisible by another number
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("ERROR: Cannot be divided by 0.");
		}
		return dividend % divisor == 0;
	}
	
	// takes two integers and returns the smallest one
	public static int min(int num1, int num2) {
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	// evaluates the greatest common factor of two numbers
	public static int gcf(int num1, int num2) {
		int gcf = 1;
		num1 = absValue(num1);
		num2 = absValue(num2);
		for (int i = 1; i <= min(num1, num2); i++) {
			if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
				if (gcf < i) {
					gcf = i;
				}
			}
		}
		return gcf;
	}
	
	// converts an improper fraction into a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		int mixed = numerator / denominator;
		int newNumerator = numerator % denominator;
		if (mixed == 0) {
			return mixed + "_" + (int) newNumerator + "/" + (int) denominator;
		} else {
			return mixed + "_" + (int) absValue(newNumerator) + "/" + (int) absValue(denominator);
		}
	}
	
	// returns the absolute value of a number
	public static int absValue(int operand) {
		if (operand < 0) {
			return -operand;
		} else {
			return operand;
		}
	}
	
	// adds or subtracts the fractions
	public static int[] addOrSubtract(int[] frac1, String operator, int[] frac2) {
		int comDenom = frac1[1] * frac2[1];
		frac1[0] *= frac2[1];
		frac2[0] *= frac1[1];
		int numer = 0;
		if (operator.equals("-")) {
			frac2[0] = -frac2[0];
		}
		numer = frac1[0] + frac2[0];
		int[] result = {numer, comDenom};
		return result;
	}	
	
	// multiplies or divides the two fractions
	public static int[] multiplyOrDivide(int[] frac1, String operator, int[] frac2) {
		int numer = 0;
		int denom = 1;
		if (operator.equals("/")) {
			int newDenom = frac2[0];
			frac2[0] = frac2[1];
			frac2[1] = newDenom;
		}
		numer = frac1[0] * frac2[0];
		denom = frac1[1] * frac2[1];
		if (numer < 0 && denom < 0) {
			numer = -numer;
			denom = -denom;
		}
		int[] result = {numer, denom};
		return result;
	}
	
	public static String reduceFrac(int numer, int denom) {
		String result = "";
		int gcfFrac = gcf(numer, denom);
		numer /= gcfFrac;
		denom /= gcfFrac;
		if (numer > 0 && denom < 0) {
			numer = -numer;
			denom = -denom;
		}
		if (numer > denom || (numer < 0 && numer < denom)) {
			result = toMixedNum(numer, denom);
			if (result.charAt(0) == '0') {
				result = numer + "/" + denom;
			}
		} else {
			result = numer + "/" + denom;
		}
		if (numer == 0) {
			result = "0";
		}
		if (denom == 0) {
			throw new IllegalArgumentException("ERROR: Cannot divide by 0.");
		}
		if (denom == 1) {
			result = numer + "";
		}
		return result;
	}
}
