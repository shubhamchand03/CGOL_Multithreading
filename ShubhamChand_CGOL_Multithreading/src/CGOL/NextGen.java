package CGOL;

/**
 * Title: Next Generation - It is the function which is used for generating next
 * generation
 * 
 * @author Shuhbam Chand
 * 
 */
public class NextGen extends Thread {
	// Two arrays are declared
	private int[][] a;
	private int[][] a1 = new int[6][6];

	public NextGen(int[][] a) {
		this.a = a;
	}

	public void run() {
		long begin = System.nanoTime(); // Current time of Execution process stored in 'begin' variable
		int i, j;
		// For counting alive cell surrounding to the observed cell
		for (i = 1; i < 5; i++) {
			for (j = 1; j < 5; j++) {
				int alive = 0, l, w;
				for (l = -1; l <= 1; l++) {
					for (w = -1; w <= 1; w++) {
						alive = alive + a[i + l][j + w];
					}
				}
				alive = alive - a[i][j];

				// Rules of CGOl is implemented below
				if (a[i][j] == 1 && alive < 2)
					a1[i][j] = 0;
				else if (a[i][j] == 1 && alive > 3)
					a1[i][j] = 0;
				else if (a[i][j] == 0 && alive == 3)
					a1[i][j] = 1;
				else
					a1[i][j] = a[i][j];
			}
		}
		// Print the next generation

		System.out.println("\nNext generation");
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				System.out.print(a1[i][j] + " ");
			}
			System.out.println();
		}
		// Assigning all the elements of next generation array to the previous original
		// array
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				a[i][j] = a1[i][j];
			}
		}
		long end = System.nanoTime(); // Current time of execution process stored in 'end' variable

		// Now subtract begin from end to calculate the execution time of the next
		// generation process.
		System.out.println("\nTime duration for execution of this generation: " + (end - begin) + " nanoseconds");

		System.out.println("\nEnter y for next generation or n for quit");
	}
}
