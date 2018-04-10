package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() < 10) {
			return getDoubleValue() + pad(getDoubleValue() + "");
		} else {
			return (getDoubleValue() + "").substring(0, 10);
		}
	}
	public String fullCellText() {
		return getVal() + "";
	}
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
