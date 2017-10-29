
import java.util.*;

public class Split {
	
	public static void main(String[] args) {
		String sandwich = "applesbreadpineappleslettustomatobaconmayohambreadcheese";

		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/

		System.out.println(sandwichMiddle(sandwich));

		//Your task Part 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
		
		String sandwich2 = "apples pineapples bread lettus tomato bacon mayo ham bread cheese";
		System.out.println(sandwichMiddle2(sandwich2));
	}
	
	public static String sandwichMiddle(String sandwich) {
		String[] toppings = new String[sandwich.split("bread").length];
		String middle = ""; // everything in the middle of the sandwich excluding bread
		for (int i = 0; i < toppings.length; i++) {
			toppings[i] = sandwich.split("bread")[i];
		}
		for (int i = 1; i < toppings.length-1; i++) {
			middle += toppings[i] + " ";
		}
		return middle;
	}
	
	public static String sandwichMiddle2(String sandwich) {
		String[] toppings = new String[sandwich.split(" ").length];
		int numBread = 0;
		for (int i = 0; i < toppings.length; i++) {
				toppings[i] = sandwich.split(" ")[i];
				if (toppings[i].equals("bread")) {
					numBread++;
				}
		}
		
		int[] breadIndices = new int[numBread];
		int counter = 0;
		for (int i = 0; i < toppings.length; i++) {
			if (toppings[i].equals("bread")) {
				breadIndices[counter] = i;
				counter++;
			}
		}
		
		String middle = "";
		for (int i = breadIndices[0] + 1; i < breadIndices[breadIndices.length - 1]; i++) {
			middle += toppings[i] + " ";
		}
		
		return middle;
	}
}