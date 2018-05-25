package textExcel;

// cell that contains numbers and/or mathematical operations
public abstract class RealCell implements Cell {
	private String value;
	
	public RealCell(String input) {
		value = input;
	}
	public abstract String abbreviatedCellText();
	public abstract String fullCellText();
	
	// returns value as a Double
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	
	// returns value as a String
	public String getVal() {
		return value;
	}
	
	// pads the cell with extra spaces if the value is less than 10 digits
	public String pad(String text) {
		String numSpaces = "";
		for (int i = 0; i < 10 - text.length(); i++) {
			numSpaces += " ";
		}
		return numSpaces;
	}
}
