package textExcel;

import textExcel.TestsALL.Helper;

// initializes spreadsheet and parses the type of cell that's being
// created depending on user input

public class Spreadsheet implements Grid
{
	private int numRows = 20;
	private int numCols = 12;
	private Cell[][] spreadsheet = new Cell[numRows][numCols];
	
	public Spreadsheet() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				spreadsheet[row][col] = new EmptyCell();
			}
		}
	}
	@Override
	// processes user input and incorporates into the textExcel spreadsheet
	public String processCommand(String command)
	{
		String result = "";
		if (command.equals("")) {
			// does nothing in case of empty string being passed in 
		// clears either the entire grid or a single cell
		} else if (command.split(" ", 2)[0].toLowerCase().equals("clear")) {
			if (command.contains(" ")) {
				String cellName = command.split(" ")[1];
				SpreadsheetLocation cell = new SpreadsheetLocation(cellName);
				spreadsheet[cell.getRow()][cell.getCol()] = new EmptyCell();
				result = getGridText();
			} else {
				for (int i = 0; i < numRows; i++) {
					for (char j = 0; j < numCols; j++) {
						spreadsheet[i][j] = new EmptyCell();
					}
				}
				result = getGridText();
			}
		// input entered is a cell location
		} else if (Character.isLetter(command.charAt(0)) && Character.isDigit(command.charAt(1))) {
			String cellName = command.split(" ", 3)[0];
			SpreadsheetLocation cell = new SpreadsheetLocation(cellName);
			if (command.contains("=")) {
				String value = command.split(" ", 3)[2];
				Cell target = spreadsheet[cell.getRow()][cell.getCol()];
				// determines whether the cell contains text (TextCell or FormulaCell) or numbers (RealCell)
				if (!Character.isDigit(value.charAt(0)) && value.charAt(0) != '-') {
					// checks if the cell contains parentheses, in which case it would be a FormulaCell
					if (value.charAt(0) == '(' && value.charAt(value.length() - 1) == ')') {
						spreadsheet[cell.getRow()][cell.getCol()] = new FormulaCell(value, spreadsheet);
					} else {
						spreadsheet[cell.getRow()][cell.getCol()] = new TextCell(value);
					}
				} else {
					// checks if cell has a percent sign (PercentCell) or a decimal/number (ValueCell)
					if (value.contains("%")) {
						spreadsheet[cell.getRow()][cell.getCol()] = new PercentCell(value);
					} else if (value.contains(".") || Character.isDigit(value.charAt(0))
							|| value.charAt(0) == '-') {
						spreadsheet[cell.getRow()][cell.getCol()] = new ValueCell(value);
					}
				}
				result = getGridText();
			} else {
				result = spreadsheet[cell.getRow()][cell.getCol()].fullCellText();
			}
		} else {
			System.out.println("Unknown command. Type 'quit' to exit the program.");
		}
		return result;
	}

	@Override
	public int getRows()
	{
		return numRows;
	}

	@Override
	public int getCols()
	{
		return numCols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	// displays the current grid of cells
	public String getGridText() {
	String grid = "";
	// first row - column header
	String firstRow = "   |";
	for (int i = 'A'; i <= 'L'; i++) {
		firstRow += (char) i + "         |";
	}
	grid += firstRow + "\n";
	// the rest of the rows - table of values
	for (int i = 0; i < numRows; i++) {
		String row = "";
		row += String.format("%-3s", i+1) + "|";
		for (int j = 0; j < numCols; j++) {
			row += spreadsheet[i][j].abbreviatedCellText() + "|";
		}
		grid += row + "\n";
	}
	return grid;
	}
}
