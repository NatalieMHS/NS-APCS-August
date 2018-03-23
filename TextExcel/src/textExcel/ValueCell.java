package textExcel;

public class ValueCell extends RealCell {

	private String exactValue;
	
	public ValueCell(String input) {
		super(input);
		exactValue = input;
	}
	
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() < 10) {
			return getDoubleValue() + abrvTextSpaces(getDoubleValue() + "");
		} else {
			return (getDoubleValue() + "").substring(0, 10);
		}
	}
	public String fullCellText() {
		return exactValue + "";
	}
	public double getDoubleValue() {
		return super.getDoubleValue();
	}
}
