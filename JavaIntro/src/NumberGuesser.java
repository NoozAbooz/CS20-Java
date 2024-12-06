import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {
		// initial params
		int wins = 0;
		int losses = 0;
		boolean gameOver = false;
		int maxAttempts = 3;
		
		int min = 1, max = 2;
		int level = 1;
		int attempts = 0;
		
		// initial random number generate
		int randomNumber = (int)(Math.random() * (max - min + 1) + min);
		
		while (true) { // game loop						
			Scanner input = new Scanner(System.in);
			System.out.println("level " + level + " - guess mah numbr (between " + min + " and " + max + ")");
			int guess = 0;
			
			// error trapping
			do {
				try {
					guess = input.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid input, type a number within the range.");
					input.nextLine();
				}
				
			} while (guess < min || guess > max);
			
			if (guess == randomNumber) {
				System.out.println("you guessed " + guess + "! it was: CORRECT! +10000 aura for you.");
				level++;
				attempts = 0;
				
				// only set difficulty on level advancement 
				switch(level) {
					case 1:
						min = 1; max = 2;
						break;
					case 2:
						min = 1; max = 10;
						break;
					case 3:
						min = 1; max = 20;
						break;
				}
				randomNumber = (int)(Math.random() * (max - min + 1) + min);
			} else if (guess != randomNumber && attempts < (maxAttempts - 1)) {
				attempts++;
				System.out.println("you got it wrong but no worries, still " + (maxAttempts - attempts) + " attempts left!");
				
				// use percentage difference for hint
				double variance = Math.abs(((guess - randomNumber) * 100) / randomNumber);
				String distance = "";
				if (variance > 20) {
					distance = "cold";
				} else if (variance > 10 && variance <= 20) {
					distance = "warm";
				} else if (variance <= 10) {
					distance = "HOTHOTHOTHOT";
				}
				System.out.println("your guess was " + distance);
			} else {
				System.out.println("you used up all your attempts.");
				gameOver = true;
			}
			
			if (level == 4 || gameOver == true) { // end game after 3 levels regardless
				if (gameOver == true) {
					losses++;
				} else {
					wins++;
				}
				
				System.out.println("game over! press ENTER to play again.");
				try
		        {
		            System.in.read();
		            input.nextLine();
		        }  
		        catch(Exception e)
		        {}
				
				// reset game vars
				level = 1;
				attempts = 0;
				gameOver = false;
				min = 1; max = 2;
				
				System.out.println("");
				System.out.println("Welcome! Your win/loss ratio is: " + wins + " - " + losses);
			}
			
			input.nextLine();
		}
	}
}
