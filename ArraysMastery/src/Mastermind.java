
public class Mastermind {
	public static void display(int arr[][]) { // print for debugging
		for (int l = 0; l < arr.length; l++) {
			System.out.print(arr[l][0] + " ");
			System.out.print(arr[l][1] + " ");
			System.out.print(arr[l][2] + " ");
			System.out.println(arr[l][3]);
		}
	}

	public static void main(String[] args) {
		int coloursAmount = myTools.userInput("How many colours does your board have? ", 1, 9);
		int combinations = (int) Math.pow(coloursAmount, 4);
		
		int solutionSet[][] = new int[combinations][4];
		boolean possible[] = new boolean[combinations];
		
		int rowNumber = 0; // populate with nested loop for every 8x8x8x8 combo
		// i love combinatorics!!!!
		for (int a = 1; a <= coloursAmount; a++) {
			for (int b = 1; b <= coloursAmount; b++) {
				for (int c = 1; c <= coloursAmount; c++) {
					for (int d = 1; d <= coloursAmount; d++) {
						solutionSet[rowNumber][0] = a; 
						solutionSet[rowNumber][1] = b;
						solutionSet[rowNumber][2] = c;
						solutionSet[rowNumber][3] = d;
						
						rowNumber++;
					}
				}
			}
		}
		
		for (int i = 0; i < combinations; i++) { // switch from default false value to true
			possible[i] = true;
		}
		
		for (int attempts = 1; attempts > 0; attempts++) { // finicky logic to count number of loop iterations
			// step 5) find first POSSIBLE value in the list
			int selectedIndex = 0;

			// this code did not work out well :(
//			if (attempts == 1) { 
//				// use 1122 as the guess on first attempt, its statistically better to guess with
//				// see https://math.stackexchange.com/questions/1192961/knuths-mastermind-algorithm
//				System.out.print(solutionSet[9][0] + " ");
//				System.out.print(solutionSet[9][1] + " ");
//				System.out.print(solutionSet[9][2] + " ");
//				System.out.println(solutionSet[9][3]);
//				selectedIndex = 9;
//			}
			
			for (int i = 0; i < solutionSet.length; i++) { // find first possible guess in the list
				if (possible[i] == true) {
					System.out.print(solutionSet[i][0] + " ");
					System.out.print(solutionSet[i][1] + " ");
					System.out.print(solutionSet[i][2] + " ");
					System.out.println(solutionSet[i][3]);
					selectedIndex = i;
					break;
				}
			}
			
			// step 6
			int correctPositions = myTools.userInput("How many were in the correct spot?", 0, 4);
			if (correctPositions == 4) {
				System.out.println("Congrats on solving this puzzle! You used " + attempts + " attempts.");
				break;
			}
			int wrongPositions = myTools.userInput("How many were in the wrong spot?", 0, 4); 
			
			// step 7, change possible array to false (if the program doesn't break earlier, this will run)
			possible[selectedIndex] = false;
			
			// step 8
			for (int i = 0; i < solutionSet.length; i++) {
				int localCorrectPositions = 0;
				int localWrongPositions = 0;
					
				char[] guess = new char[4];
				char[] selectedSolution = new char[4];
				
				for (int k = 0; k < 4; k++) { // write into temporary char array so we can delete elements
					guess[k] = (char) (solutionSet[selectedIndex][k] + '0'); // convert int to char
					selectedSolution[k] = (char) (solutionSet[i][k] + '0');
				}
				
				for (int k = 0; k < 4; k++) { // find in correct positions and eliminate
					if (guess[k] == selectedSolution[k]) {
						localCorrectPositions++;
						selectedSolution[k] = '!';
					}
				}
				
				for (int k = 0; k < 4; k++) { // find in wrong positions and eliminate
					for (int j = 0; j < 4; j++) {
						if (guess[k] == selectedSolution[j]) {
							localWrongPositions++;
							selectedSolution[j] = '!';
						}
					}
				}
				
				
				if (!(localCorrectPositions == correctPositions && localWrongPositions == wrongPositions)) {
					possible[i] = false;
				}
			}
		}

	}

}