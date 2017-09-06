/* Natalie Suboc
 * September 9, 2017
 * Self-written Math library 
 * Contains a series of methods to do basic math functions */


public class Calculate {
	
	// squares the input
	public static int square(int operand) {
		return operand * operand;
	}
	
	// cubes the input
	public static int cube(int num) {
		return num * num * num;
	}
	
	// takes the average of two numbers
	public static double average(double num1, double num2) {
		return ((num1 + num2) / 2);
	}
	
	// takes the average of three numbers
	public static double average(double num1, double num2, double num3) {
		return ((num1 + num2 + num3) / 3);
	}
	
	// converts a radian value to degrees
	public static double toDegrees(double radian) {
		return (radian * (360 / (2 * 3.14159)));
	}
	
	// converts a degree value to radians
	public static double toRadians(double degree) {
		return (degree * ((2 * 3.14159) / 360) );
	}
	
	// takes the a, b, and c from the equation ax^2 + bx + c and returns the discriminant
	public static double discriminant(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	// converts a mixed number into an improper fraction
	public static String toImproperFrac(int wholeNum, int numerator, int denominator) {
		int improper = (wholeNum * denominator) + numerator;
		return improper + "/" + denominator;
	}
	
	// converts an improper fraction into a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		int mixed = numerator / denominator;
		int newNumerator = numerator % denominator;
		return mixed + " " + newNumerator + "/" + denominator;
	}
	
	//
	public static String foil(int num1, int num2, int num3, int num4, String varName) {
		int a = num1 * num3;
		int b = (num1 * num4) + (num2 * num3);
		int c = num2 * num4;
		return a + varName + "^2 + " + b + varName + " + " + c;
	}
	
	public static boolean isDivisibleBy() {
		return true;
	}
}

