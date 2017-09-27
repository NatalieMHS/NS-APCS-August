/* Natalie Suboc
 * September 25, 2017
 * Library containing series of methods used
 * to describe the graph of a quadratic function
 */

public class Quadratic {

	public static String quadrDescriber(double a, double b, double c) {
		String desc = "";
		desc += "Description of the graph of: \n";
		String equation = a + "x^2 + " + b + "x + " + c;
		desc += equation + "\n\n";
		if (a >= 0) {
			desc += "Opens: up\n";
		} else {
			desc += "Opens: down\n";
		}
		double h = -b / (2 * a); // from the equation a(x-h)^2 + k; also the axis of symmetry
		desc += "Axis of Symmetry: " + h + "\n";
		double k = c - (h * h); // from the equation a(x-h)^2 + k
		desc += "Vertex: (" + h + ", " + k + ")\n";
		
		return desc;
	}
	
	public static String quadForm(int a, int b, int c) {
		double discr = discriminant(a, b, c);
		if (discr < 0) {
			return "no real roots";
		} else if (discr == 0) {
			double result = (-b + sqrt(discr)) / (2 * a);
			return round2(result) + "";
		} else {
			double posResult = (-b + sqrt(discr)) / (2 * a);
			double negResult = (-b - sqrt(discr)) / (2 * a);
			return round2(negResult) + " and " + round2(posResult);
		}
	}
		
		public static double sqrt(double num) {
			double guess = 0.1;
			double guessSqrt = 0;
			if (num < 0) {
				throw new IllegalArgumentException("The square root of " + num + " is imaginary.");
			}
			while (round2(guessSqrt * guessSqrt) != num) {
				guessSqrt = 0.5 * (num / guess + guess);
				guess += 0.1;
			}
			return round2(guessSqrt);
		}
		
		public static double round2(double num) {
			int noDecimalsNum = (int) (num * 1000); // removes decimals beyond the thousandths place
			int thousandthDigit = noDecimalsNum % 10;
			noDecimalsNum /= 10;
			// increments if number is positive, decrements if number is negative
			if (thousandthDigit >= 5 && noDecimalsNum > 0) {
				noDecimalsNum += 1;
			} else if (thousandthDigit <= -5 && noDecimalsNum < 0) {
				noDecimalsNum -= 1;
			}
			return noDecimalsNum / 100.0; // returns the rounded value and makes it a double
		}
		
		public static double discriminant(double a, double b, double c) {
			return (b * b) - (4 * a * c);
		}
}
