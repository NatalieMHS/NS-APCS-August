/* Natalie Suboc
 * September 25, 2017
 * Client for Quadratic used to test methods
 */

import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Type in the values for the quadratic equation ax^2 + bx + c");
		System.out.print("a: ");
		double a = userInput.nextInt();
		System.out.print("b: ");
		double b = userInput.nextInt();
		System.out.print("c: ");
		double c = userInput.nextInt();
		// quadrDescriber(a, b, c);
	}

}
