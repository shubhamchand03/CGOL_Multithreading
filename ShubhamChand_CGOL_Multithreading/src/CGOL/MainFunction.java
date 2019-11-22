package CGOL;

import java.util.Scanner;

public class MainFunction {
	static int[][] a = new int[6][6];

	public static void main(String[] args) {
		char ch;
		System.out.println("CGOl using Thread Class");
		System.out.println("Enter the elements in the array 6 x 6 ");
		System.out.println("0 is used for dead cell and 1 is used for live cell. ");
		Scanner s = new Scanner(System.in);
		// Elements are taken as input by the user.
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				a[i][j] = s.nextInt();
			}
		}
		// 'x' object is created of PrintArray Class
		PrintArray x = new PrintArray(a);
		
		// Priority is set for this current thread.
		x.setPriority(9);
		
		// Execution of 'x' thread parallel to the program.
		x.start();
		
		// Loop is used for generating next generation until the user want with the help of thread.
		do {
			NextGen g = new NextGen(a); 
			g.setPriority(5);
			g.start();
			ch = s.next().charAt(0);
		} while (ch == 'y');

		System.out.println("Thank you, Exit..!!");

		s.close();
	}
}
