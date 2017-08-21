package hello_world;

import java.util.Scanner;
import hello_world.*;

public class Hello_World {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println(add(1, 2));
		System.out.println(Math_Thing.subtract(2, 1));
		
	}
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static void random() {
		Scanner num = new Scanner(System.in);
		int userNum = num.nextInt();
		for (int i = 0; i < 10; i++) {
			userNum += 1;
		}
		num.close();
	}
	
	
}
