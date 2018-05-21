package textExcel;

import java.util.Arrays;

// type of cell that holds a formula - 
// combination of operations that include numbers and locations of cells with numbers

public class FormulaCell extends RealCell {
	
	Cell[][] spreadsheet;
	
	public FormulaCell(String input, Cell[][] spreadsheet) {
		super(input);
		this.spreadsheet = spreadsheet;
		
	}
	
	// returns value displayed on the grid
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() < 10) {
			return getDoubleValue() + pad(getDoubleValue() + "");
		} else {
			return (getDoubleValue() + "").substring(0, 10);
		}
	}
	
	// returns actual value
	public String fullCellText() {
		return getVal();
	}
	
	// parses FormulaCell and returns the simplified result
	public double getDoubleValue() {
		String[] splitFormula = (getVal().substring(2, getVal().length() - 2)).split(" ");
		if (splitFormula.length <= 1) {
			return Double.parseDouble(splitFormula[0]);
		} else if (getVal().toUpperCase().contains("SUM")) {
			String[] cellLocs = splitFormula[1].split("-");
			return sum(cellLocs[0], cellLocs[1]);
		} else if (getVal().toUpperCase().contains("AVG")) {
			String[] cellLocs = splitFormula[1].split("-");
			return avg(cellLocs[0], cellLocs[1]);
		} else {
			for (int i = 0; i < splitFormula.length; i++) {
				if (Character.isLetter(splitFormula[i].charAt(0))) {
					Location cell = new SpreadsheetLocation(splitFormula[i]);
					splitFormula[i] = ((RealCell) spreadsheet[cell.getRow()][cell.getCol()]).getDoubleValue() + "";
				}
			}
			double result = doOperation(Double.parseDouble(splitFormula[0]), splitFormula[1],
				Double.parseDouble(splitFormula[2]));
			for (int i = 2; i < splitFormula.length - 1; i += 2) {
				result = doOperation(result, splitFormula[i+1],
						Double.parseDouble(splitFormula[i+2]));
			}
			return result;
		}
	}
	// performs several basic arithmetic operators
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
	// returns the sum of a selected section of cells
	public double sum(String startCell, String endCell) {
		double sum = 0;
		SpreadsheetLocation start = new SpreadsheetLocation(startCell);
		SpreadsheetLocation end = new SpreadsheetLocation(endCell);
		for (int i = start.getRow(); i <= end.getRow(); i++) {
			for (int j = start.getCol(); j <= end.getCol(); j++) {
				RealCell target = (RealCell) spreadsheet[i][j];
				sum += target.getDoubleValue();
			}
		}
		return sum;
	}
	// returns the average of a selected section of cells
	public double avg(String startCell, String endCell) {
		SpreadsheetLocation start = new SpreadsheetLocation(startCell);
		SpreadsheetLocation end = new SpreadsheetLocation(endCell);
		int numCells = ((end.getCol() + 1) - start.getCol()) * ((end.getRow() + 1) - start.getRow());
		return sum(startCell, endCell) / (double) numCells;
	}
}
