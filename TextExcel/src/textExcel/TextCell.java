package textExcel;

import textExcel.TestsALL.Helper;

public class TextCell implements Cell {
	private String text;
	
	public TextCell(String t) {
		text = t;
	}
	
	public String abbreviatedCellText() {
		String abrvText = ""; // TODO: remove redundancy
		if (text.length() > 10) {
			if (text.contains("\"")) {
				String noQuotesText = text.substring(1, text.length()-1);
				if (noQuotesText.length() > 10) {
					for (int i = 0; i < 10; i++) {
						abrvText += noQuotesText.charAt(i);
					}
				} else {
					abrvText = noQuotesText;
				}
			} else {
				for (int i = 0; i < 10; i++) {
					abrvText += text.charAt(i);
				}
			}
		} else {
			if (text.charAt(0) == '"') {
				abrvText = text.substring(1, text.length()-1);
			} else {
				abrvText = text;
			}
		}
		int numSpaces = 10 - abrvText.length();
		for (int i = 0; i < numSpaces; i++) {
			abrvText += " ";
		}
		return abrvText;
	}
	
	public String fullCellText() {
		return text;
	}
}
