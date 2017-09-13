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
	
	public static boolean isDivisibleBy(int dividend, int divisor) {
		return dividend % divisor == 0;
	}
	
	public static double absValue(double operand) {
		if (operand < 0) {
			return -operand;
		} else {
			return operand;
		}
		// return (operand < 0) ? -operand : operand;
	}
	
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
		// return (num1 > num2) ? num1 : num2;
	}
	
	public static double round2(double num) {
		/* if decimal place is >= 5, round up; else, round down
		 * get decimal place - cast then index? or could array
		 * have to put it back together though
		 * import a math library lol
		 */
		String numText = Double.toString(num);
		double thirdDecPlace = numText.charAt(0);
		System.out.println(thirdDecPlace);
		if (thirdDecPlace >= 5) {
			System.out.println(0.001 * (10 -thirdDecPlace));
			return (num + (0.001 * (10 - thirdDecPlace)));
		} else {
			System.out.println(0.001 * (thirdDecPlace));
			return (num - (0.001 * thirdDecPlace));
		}
	}
}

