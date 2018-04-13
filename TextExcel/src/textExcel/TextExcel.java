package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.Helper;

/* Natalie Suboc
 * April 12, 2018
 * TextExcel Project - recreation of an excel spreadsheet
 * with basic commands such as setting text and manipulating
 * numbers
 */

public class TextExcel
{

	public static void main(String[] args)
	{
	    Scanner console = new Scanner(System.in);
	    Spreadsheet mySpreadsheet = new Spreadsheet();
	    while (true) {
	    		System.out.print("> ");
	    		String command = console.nextLine();
	    		if (command.toLowerCase().equals("quit")) {
	    			break;
	    		}
	    		System.out.print(mySpreadsheet.processCommand(command));
	    		
	    }
	}
}
