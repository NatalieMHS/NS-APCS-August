/* Natalie Suboc
 * Oct 4, 2017
 * Contains the pair programming task written in class,
 * ProcessingNumbers
 */
import java.util.*;

public class PairProgramming {

	public static void main(String[] args) {
		processingNumbers();
	}
	
	public static void processingNumbers() {
		Scanner userInput = new Scanner(System.in);
		int max = 0;
		int min = 0;
		int sum = 0;
		int evenMax = 0;
		boolean done = false;
		boolean first = true;
		do {
			System.out.print("Input a number: ");
			int num = userInput.nextInt();
			if (first) {
				max = num;
				min = num;
				first = false;
			} else {
				if (num > max) {
					max = num;
				}
				if (num < min) {
					min = num;
				}
			}
			if (num % 2 == 0) {
				sum += num;
				if (num > evenMax) {
					evenMax = num;
				}
			}
			System.out.println("Are we finished? If so, type 'yes'.");
			String finished = userInput.next();
			if (finished.equals("yes")) {
				done = true;
			}
		} while (!done);
		System.out.println("Max: " + max + "\nMin: " + min);
		System.out.println("Sum of even numbers: " + sum + "\nLargest even number: " + evenMax);
		userInput.close();
	}

}