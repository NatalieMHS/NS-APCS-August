package textExcel;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String t) {
		text = t;
	}
	
	public String abbreviatedCellText() {
		String abrvText = "";
		for (int i = 0; i < 10; i++) {
			abrvText += text.charAt(i);
		}
		return abrvText;
	}
	
	public String fullCellText() {
		return "\"" + text + "\"";
	}
}
