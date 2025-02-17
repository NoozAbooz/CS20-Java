
public class TwoDimensionPractice {

	public static void main(String[] args) {
		int[][] manta = new int[20][20];
		
		// populate random and print out
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				manta[i][j] = myTools.random(1, 100);
				//System.out.print(manta[i][j]);
			}
		}

		for (int i = 0; i < manta.length; i++) {
			for (int k = 0; k < manta.length; k++) {
				if (manta[i][k] < 10) {
					System.out.print(manta[i][k] + "   ");
				} else if (manta[i][k] < 100) {
					System.out.print(manta[i][k] + "  ");
				} else {
					System.out.print(manta[i][k] + " ");
				}
				
				if ((k + 1) % 20 == 0) {
					System.out.println();
				}
			}
		}
		
		int largestSum = 0;
		int largestX = 0;
		int largestY = 0;
		/// 3x3 grid with largest sum
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (i < (manta.length - 2) && j < (manta[0].length - 2)) {
					int sumRow1 = manta[i][j] + manta[i][j+1] + manta[i][j+2];
					int sumRow2 = manta[i+1][j] + manta[i+1][j+1] + manta[i+1][j+2];
					int sumRow3 = manta[i+2][j] + manta[i+2][j+1] + manta[i+2][j+2];
					
					int sum = (sumRow1 + sumRow2 + sumRow3);
					
					if (sum > largestSum) {
						largestX = i; // row ("y")
						largestY = j; // column ("x")
						largestSum = sum;
					}
				}
			}
		}
		
		// coordinates of the top left corner of the grid
		System.out.println("Max sum: " + largestSum + " at (" + largestX + ", " + largestY + ") -> (row, col)");
	}

}
