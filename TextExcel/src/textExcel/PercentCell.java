package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String roundedVal = getVal();
		if (getVal().contains(".")) {
			roundedVal = getVal().substring(0, getVal().indexOf(".")) + "%";
		}
		if (roundedVal.length() < 10) {
			return roundedVal + pad(roundedVal);
		} else {
			return roundedVal.substring(0, 10);
		}
	}
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	public double getDoubleValue() {
		return Double.parseDouble(getVal().substring(0, getVal().length()-1)) * 0.01;
	}

}
