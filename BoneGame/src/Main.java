
public class Main {

	public static void main(String[] args) {
		int playerScore = 0;
		int cpuScore = 0;
		
		while ((playerScore < 20) && (cpuScore < 20)) {
			System.out.println();
			System.out.println("Bone Game");
			System.out.println("===================");
			System.out.println("Player:" + playerScore + "     CPU:" + cpuScore);
			System.out.println("===================");
			int playerTurnScore = playerTurn();
			playerScore += playerTurnScore;
			
			cpuScore += computerTurn(playerTurnScore);
		}
		
		if (playerScore != cpuScore) { // win/loss
			System.out.println();
			if (playerScore > cpuScore) {
				System.out.println("YOU WIN! " + playerScore + " - " + cpuScore);
			} else {
				System.out.println("YOU LOST, CPU win. " + playerScore + " - " + cpuScore);
			}
		}
		
		if (playerScore == cpuScore) { // tie
			System.out.println();
			System.out.println("GAME TIED! " + playerScore + " - " + cpuScore);
		}
	}
	
	public static int playerTurn() {
		int attempts = 1;
		int pointsEarned = 0;
		
		do {
			System.out.println("Player throw: " + attempts);
			
			for (int i = 1; i <= 5; i++) {
				int state = myTools.random(0, 1);
				
				if (state == 1) { // facing up
					switch (i) {
					case 1:
						System.out.print("Rectangles! ");
						pointsEarned += 1;
						break;
					case 2:
						System.out.print("Squares! ");
						pointsEarned += 1;
						break;
					case 3:
						System.out.print("Triangles! ");
						pointsEarned += 2;
						break;
					case 4:
						System.out.print("Circles! ");
						pointsEarned += 3;
						break;
					case 5:
						System.out.print("Diamonds! ");
						pointsEarned += 4;
						break;
					}
				} else { // blank
					System.out.print("∅ ");
				}
			}
			System.out.println("");
			System.out.println("Points this attempt: " + pointsEarned);
			System.out.println("");
			
			if (attempts < 3) {
				char input = myTools.getChar("Do you want to toss again? (y/n)");
				if (input == 'y' && attempts < 3) {
					attempts++;
					pointsEarned = 0;
				} else {
					attempts = 4;
				}
			} else {
				attempts = 4;
			}
			
		} while (attempts < 4);
		
		return pointsEarned;
	}
	
	public static int computerTurn(int playerScore) {
		double riskTolerance = 0.5;
		int attempts = 1;
		int cpuPointsEarned = 0;
		
		do {
			System.out.println("CPU throw: " + attempts);
			
			for (int i = 1; i <= 5; i++) {
				int state = myTools.random(0, 1);
				
				if (state == 1) { // facing up
					switch (i) {
					case 1:
						System.out.print("Rectangles! ");
						cpuPointsEarned += 1;
						break;
					case 2:
						System.out.print("Squares! ");
						cpuPointsEarned += 1;
						break;
					case 3:
						System.out.print("Triangles! ");
						cpuPointsEarned += 2;
						break;
					case 4:
						System.out.print("Circles! ");
						cpuPointsEarned += 3;
						break;
					case 5:
						System.out.print("Diamonds! ");
						cpuPointsEarned += 4;
						break;
					}
				} else { // blank
					System.out.print("∅ ");
				}
			}
			System.out.println("");
			System.out.println("Points this attempt: " + cpuPointsEarned);
			System.out.println("");
			
			if (attempts < 3 && (throwOdds(cpuPointsEarned) >= riskTolerance || throwOdds(playerScore) >= riskTolerance)) {
				attempts++;
				cpuPointsEarned = 0;
			} else {
				attempts = 4;
			}
			
		} while (attempts < 4);
		
		return cpuPointsEarned;
	}
	
	public static double throwOdds(int t) { // odds that any throw will meet or exceed t
		double count = 0;
		int points = 0;
		
		for (int A = 0; A <= 1; A++) { // bone A
			
			for (int B = 0; B <= 1; B++) { // bone B
				
				for (int C = 0; C <= 1; C++) { // bone C
					
					for (int D = 0; D <= 1; D++) { // bone D
						
						for (int E = 0; E <= 1; E++) { // bone E
							points = (A * 1) + (B * 1) + (C * 2) + (D * 3) + (E * 4);
							if (points > t) { 
								count++;
							}
							points = 0;
						}
					}
				}
			}
		}
		
		return count / 32;
	}
}
  