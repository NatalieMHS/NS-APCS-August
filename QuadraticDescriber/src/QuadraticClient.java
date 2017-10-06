/* Natalie Suboc
 * September 25, 2017
 * Client for Quadratic used to test methods
 */

import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		boolean done = false;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to Quadratic Describer");
		do {
			System.out.println("Type in the values for the quadratic equation ax^2 + bx + c");
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Would you like to continue? If not, type 'quit' to end.");
			String finished = userInput.next();
			if (finished.charAt(0) == ('q')) {
				done = true;
			}
		} while (!done);
		userInput.close();
	}
}
