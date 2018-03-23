package textExcel;

public class FormulaCell extends RealCell {
	
	private String exactValue;
	public FormulaCell(String input) {
		super(input);
		exactValue = input;
		
	}
	public String abbreviatedCellText() {
		if (exactValue.length() < 10) {
			return exactValue + abrvTextSpaces(exactValue);
		} else {
			return exactValue.substring(0, 10);
		}
	}
	public String fullCellText() {
		return exactValue;
	}
	public double getDoubleValue() {
		double result = 0;
		String[] splitFormula = (exactValue.substring(1, exactValue.length() - 1)).split(" ");
		for (int numIdx = 0; numIdx < splitFormula.length; numIdx += 2) {
			
		}
		return 0.0;
	}

	public double doOperation(double num1, String operator, double num2) {
		double result = 0;
		if (operator.equals("+"))
			result = num1 + num2;
		else if (operator.equals("-"))
			result = num1 - num2;
		else if (operator.equals("*"))
			result = num1 * num2;
		else if (operator.equals("/"))
			result = (double) num1 / num2;
		return result;
	}
}
