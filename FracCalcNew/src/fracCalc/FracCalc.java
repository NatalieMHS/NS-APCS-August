/* Natalie Suboc
 * December 13, 2017
 * FracCalc client code
 */ 

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
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
    public static String produceAnswer(String input)
    { 
        Fraction frac = new Fraction(input);
        return frac.toString(frac);
    }
 
}
