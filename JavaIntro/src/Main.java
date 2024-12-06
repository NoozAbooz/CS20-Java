import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* input updatedPrice */
//		System.out.println("what is ur name?!?!?!?");
//		
//		// shortcut to load libraries - ctrl shift o
//		// left = name
//		// right = assigns to read from system in/keyboard input
//		Scanner input = new Scanner(System.in);
//		String nameInput = input.next();
//		System.out.println("Hi, " + nameInput);
//		
//		System.out.println("how old r u?!?!");
//		int number = input.nextInt();
		
		
		/* RNG */
		int auraBalance = 0;
		
		int min = 1, max = 5;
		
		while (true) {
			int randomNumber = (int)(Math.random() * (max - min + 1) + min);
		
			System.out.println("guess mah numbr (between " + min + " and " + max + ")");
			Scanner input = new Scanner(System.in);
			int guess = 0;
			
			while (true) {
				try {
					guess = input.nextInt();
				}
				catch(Exception e) {
				}
				
				if (guess >= min && guess <= max) {
					break;
				} else {
					System.out.println("Invalid updatedPrice outside specified range, Try again!");
					input.nextLine();
				}
			}
		
			System.out.print("you guessed " + guess + "! it was: ");
		
			if (guess == randomNumber) {
				System.out.println("CORRECT! +10 aura for you.");
				auraBalance += 10;
			} else {
				System.out.println("not correct! -10 aura for you.");
				auraBalance -= 10;
			}
		
			System.out.println("your aura sits at " + auraBalance);
			input.nextLine();
		}
	}
}
