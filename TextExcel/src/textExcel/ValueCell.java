package textExcel;

public class ValueCell extends RealCell {
	
	private double value;
	private String exactValue;
	
	public ValueCell(String val) {
		exactValue = val;
		value = Double.parseDouble(val);
	}
	
	public String abbreviatedCellText() {
		return value + "";
	}
	public String fullCellText() {
		return exactValue;
	}
}
