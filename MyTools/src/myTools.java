import java.util.Scanner;

public class myTools {
	public static int userInput(int min, int max) {
		int data = -1;
		Scanner input = new Scanner(System.in);
		
		do {
			try {
				System.out.println("Please enter a number between " + min + " and " + max + ": ");
				data = input.nextInt();
				
				if (data < min || data > max) {
					System.out.println("That is not a valid input");
					input.nextLine();
				}
			}
			catch (Exception e) {
				System.out.println("That is not a valid input");
				input.nextLine();
			}
		} while (data == -1 || data < min || data > max);
		
		return data;
	}
	public static double userInput(double min, double max) {
		double data = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			try {
				System.out.println("Please enter a decimal number between " + min + " and " + max + ": ");
				data = input.nextDouble();
				
				if (data < min || data > max) {
					System.out.println("That is not a valid input");
					input.nextLine();
				}
			}
			catch (Exception e) {
				System.out.println("That is not a valid input");
				input.nextLine();
			}
		} while (data == 0 || data < min || data > max);
		
		return data;
	}
	
	public static double userInput(String message) {
		double data = 0;
		Scanner input = new Scanner(System.in);
		
			try {
				System.out.println(message);
				data = input.nextDouble();
			}
			catch (Exception e) {
				System.out.println("That is not a valid input");
				input.nextLine();
			}
		
		return data;
	}
	
	public static int userInput(String message, int min, int max) {
		int data = -1;
		Scanner input = new Scanner(System.in);
		
		do {
			try {
				System.out.println(message);
				data = input.nextInt();
				
				if (data < min || data > max) {
					System.out.println("That is not a valid input");
					input.nextLine();
				}
			}
			catch (Exception e) {
				System.out.println("That is not a valid input");
				input.nextLine();
			}
		} while (data == -1 || data < min || data > max);
		
		return data;
	}
	
	public static char userInput(String message, char a, char b) {
		char data = '0';
		Scanner input = new Scanner(System.in);
		
		System.out.println(message);
		
		do {
			data = input.next(".").charAt(0);
		} while (data != a || data != b);
		
		return input.next(".").charAt(0);
	}
	
	public static int random(int min, int max) {
		int randomNumber = (int)(Math.random() * (max - min + 1) + min);
		return randomNumber;
	}
	
	public static double random(double min, double max) {
		return (Math.random() * (max - min + 1) + min);
	}
	
	public static int digitAt(int number, int n) {
		int digit = 0;
		int reversed = 0;
		
		while (number != 0) {
			digit = number % 10;
			reversed = reversed * 10 + digit;
			
			number /= 10;
		}
		
		for (int i = 1; i < n; i++) {
			reversed /= 10;
		}
		
		while (reversed > 10) {
			reversed = reversed % 10;
		}
		return reversed;
	}
	
	public static char getChar(String message) {
		char data = 1;
		Scanner input = new Scanner(System.in);
		
			try {
				System.out.println(message);
				data = input.next().charAt(0);
			}
			catch (Exception e) {
				System.out.println("That is not a valid input");
				input.nextLine();
			}
		
		return data;
	}
}
