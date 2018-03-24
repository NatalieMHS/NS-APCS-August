package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell {
	
	//private String exactValue;
	public FormulaCell(String input) {
		super(input);
		
	}
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() < 10) {
			return getDoubleValue() + abrvTextSpaces(getDoubleValue() + "");
		} else {
			return (getDoubleValue() + "").substring(0, 10);
		}
	}
	public String fullCellText() {
		return getVal();
	}
	public double getDoubleValue() {
		String[] splitFormula = (getVal().substring(2, getVal().length() - 2)).split(" ");
		if (splitFormula.length <= 1) {
			return Double.parseDouble(splitFormula[0]);
		} else {
			double result = doOperation(Double.parseDouble(splitFormula[0]), splitFormula[1],
				Double.parseDouble(splitFormula[2]));
			for (int i = 2; i < splitFormula.length - 1; i += 2) {
				result = doOperation(result, splitFormula[i+1],
						Double.parseDouble(splitFormula[i+2]));
			}
			return result;
		}
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
			result = ((double) num1) / num2;
		return result;
	}
}
