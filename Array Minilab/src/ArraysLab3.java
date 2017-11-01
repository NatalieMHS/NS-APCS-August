import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		
		
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] sumArr = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			sumArr[i] = arr1[i] + arr2[i];
		}
		return sumArr;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		arr2[arr2.length-1] = num;
		return arr2;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] arr2 = new int[arr.length-1];
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != idx) {
				arr2[counter] = arr[i];
				counter++;
			}
		}
		return arr2;
	}
	
	public static int sumEven(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i += 2) {
			sum += i;
		}
		return sum;
	}
	
	public static void rotateRight(int[] arr) {
		int[] rotatedArr = new int[arr.length];
		int last = arr[arr.length-1];
		for (int i = rotatedArr.length-1; i >= 1; i--) {
			rotatedArr[i] = arr[i - 1];
		}
		rotatedArr[0] = last;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rotatedArr[i];
		}
	}

}
