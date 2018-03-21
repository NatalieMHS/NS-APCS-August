package textExcel;

public abstract class RealCell implements Cell {
	
	public RealCell() {
		
	}
	public abstract String abbreviatedCellText();
	public abstract String fullCellText();
}
