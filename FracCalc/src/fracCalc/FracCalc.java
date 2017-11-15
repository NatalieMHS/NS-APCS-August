package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
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
        String operation = splitExpr[1];
        String secFrac = splitExpr[2];
        
        String[] splitFrac1 = parseFrac(firstFrac);
        String[] splitFrac2 = parseFrac(secFrac);
        
        return "whole:" + splitFrac2[0] + " numerator:" + splitFrac2[1] + " denominator:" + splitFrac2[2];
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
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
}
