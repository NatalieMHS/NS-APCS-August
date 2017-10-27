import java.util.*;

public class Split {
	
	public static void main(String[] args) {
		String sandwich = "applesbreadpineapplesbreadlettustomatobaconbreadmayohambreadcheese";
		System.out.println(sandwichMiddle(sandwich));

		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/


		//Your task Part 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
	}
	
	public static String sandwichMiddle(String sandwich) {
		String[] toppings = new String[sandwich.split("bread").length];
		//String middle = "";
		for (int i = 0; i < toppings.length; i++) {
			toppings[i] = sandwich.split("bread")[i];
		}
		return toppings[1];
	}
}
