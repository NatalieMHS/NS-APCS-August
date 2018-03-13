package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int numRows = 20;
	private int numCols = 12;
	private Cell[][] spreadsheet;
	
	public Spreadsheet() {
		spreadsheet = new EmptyCell[numRows][numCols];
	}
	@Override
	public String processCommand(String command)
	{
		return "";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
