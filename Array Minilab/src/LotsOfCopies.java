/* Natalie Suboc
 * October 30, 2017
 * Array Mini-Lab
 */
import java.util.Arrays;

public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		System.out.println(num + strMain + Arrays.toString(arrMain));
		changeMe(num, strMain, arrMain);
		System.out.println(num + strMain + Arrays.toString(arrMain));
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x++;
		str += "idek";
		arr[0] = 1000;
		
		x = 3;
		int y = x;
		x=23;
		System.out.println("y: " + y);
		
		str = "hhhhh";
		String bstr = str;
		str = "iiiiii";
		System.out.println("bstr: " + bstr);
		
		int[] newArr = arr;
		newArr[1] = arr[1];
		arr[1] = 20;
		System.out.println("newArr[1]: " + newArr[1]);
		
	}

}
