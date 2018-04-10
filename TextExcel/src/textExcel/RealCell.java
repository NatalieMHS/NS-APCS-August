package textExcel;

public abstract class RealCell implements Cell {
	private String value;
	
	public RealCell(String input) {
		value = input;
	}
	public abstract String abbreviatedCellText();
	public abstract String fullCellText();
	
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	
	public String getVal() {
		return value;
	}
	
	public String pad(String text) {
		String numSpaces = "";
		for (int i = 0; i < 10 - text.length(); i++) {
			numSpaces += " ";
		}
		return numSpaces;
	}
}
