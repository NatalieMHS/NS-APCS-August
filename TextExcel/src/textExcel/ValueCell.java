package textExcel;

// Type of cell that holds numbers

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	
	// returns value as displayed on the grid
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() < 10) {
			return getDoubleValue() + pad(getDoubleValue() + "");
		} else {
			return (getDoubleValue() + "").substring(0, 10);
		}
	}
	// returns actual cell value
	public String fullCellText() {
		return getVal() + "";
	}
	// returns value as a double
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
