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
		
	}

}
