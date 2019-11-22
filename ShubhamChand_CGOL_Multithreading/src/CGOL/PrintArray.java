package CGOL;

public class PrintArray extends Thread {

	private int[][] a;

	public PrintArray(int[][] a) {
		this.a = a;
	}
	/**
	 * The following run() method has a logic for only print 2-D array
	 */
	public void run() {
		System.out.println("\n Array:");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
