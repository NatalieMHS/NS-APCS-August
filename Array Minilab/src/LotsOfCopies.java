/* Natalie Suboc
 * October 30, 2017
 * Array Mini-Lab
 */

public class LotsOfCopies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		System.out.println(num + strMain + arrMain[0]);
		changeMe(num, strMain, arrMain);
		System.out.println(num + strMain + arrMain[0]);
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x++;
		str += "idek";
		arr[0] = 1000;
	}

}
