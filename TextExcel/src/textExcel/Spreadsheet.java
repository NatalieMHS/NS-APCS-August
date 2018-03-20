package textExcel;

import textExcel.TestsALL.Helper;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int numRows = 20;
	private int numCols = 12;
	private Cell[][] spreadsheet;
	
	public Spreadsheet() {
		spreadsheet = new Cell[numRows][numCols];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				spreadsheet[row][col] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		String result = "";
		if (command.split(" ", 2)[0].toLowerCase().equals("clear")) {
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
				spreadsheet[cell.getRow()][cell.getCol()] = new TextCell(command.split(" ", 3)[2]);
				result = getGridText();
			} else {
				result = spreadsheet[cell.getRow()][cell.getCol()].fullCellText();
			}
		} else {
			// other commands
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
	public String getGridText()
{
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
		if (i < 9) {
			row += (i+1) + "  |";
		} else {
			row += (i+1) + " |";
		}
		for (int j = 0; j < numCols; j++) {
			row += spreadsheet[i][j].abbreviatedCellText() + "|";
		}
		grid += row + "\n";
	}

	return grid;
}

}
