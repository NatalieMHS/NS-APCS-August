package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Scanner console = new Scanner(System.in);
	    Spreadsheet mySpreadsheet = new Spreadsheet();
	    while (true) {
	    		String command = console.nextLine();
	    		if (command.toLowerCase().equals("quit")) {
	    			break;
	    		}
	    		System.out.println(mySpreadsheet.processCommand(command));
	    		
	    }
	}
}
