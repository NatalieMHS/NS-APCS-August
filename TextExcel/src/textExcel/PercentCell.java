package textExcel;

public class PercentCell extends RealCell {
	
	private String exactValue;
	
	public PercentCell(String input) {
		super(input);
		exactValue = input;
	}
	
	public String abbreviatedCellText() {
		String roundedVal = exactValue;
		if (exactValue.contains(".")) {
			roundedVal = exactValue.substring(0, exactValue.indexOf(".")) + "%";
		}
		if (roundedVal.length() < 10) {
			return roundedVal + abrvTextSpaces(roundedVal);
		} else {
			return roundedVal.substring(0, 10);
		}
	}
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	public double getDoubleValue() {
		return Double.parseDouble(exactValue.substring(0, exactValue.length()-1)) * 0.01;
	}

}
