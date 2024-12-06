import java.util.Scanner;

public class MethodPractice {
	public static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true; // is even
		} else {
			return false; // odd
		}
	}
	
	public static String generateGreeting(String name) {
		String message = "Hello, " + name + "!";
		return message;
	}
	
	public static int calculateFactorial(int n) {
		int result = 1;
		for (int i = 1; i < (n + 1); i++) {
			result = result * i;
		}
		return result;
	}
	
	public static int middleValue(int a, int b, int c) {
		int median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
		return median;
	}
	
	public static int digitSum(int n) {
		n = Math.abs(n);
		int sum = 0;
		
		while (n > 0) {
			sum += (n % 10);
			n -= (n % 10);
			n = n / 10;
		}
		
		return sum;
	}
	
	public static int random(int min, int max) {
		int randomNumber = (int)(Math.random() * (max - min + 1) + min);
		return randomNumber;
	}
	
	public static int input(int min, int max) {
		int data = 0;
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
		} while (data == 0 || data < min || data > max);
		
		return data;
	}
	
	public static String romanNumeral(int n) {
		String string = "";
		
		switch ((n % 100)/10) {
			case 1: 
				string += "X";
				break;
			case 2:
				string += "XX";
				break;
			case 3:
				string += "XXX";
				break;
			case 4:
				string += "XL";
				break;
			case 5:
				string += "L";
				break;
			case 6:
				string += "LX";
				break;
			case 7:
				string += "LXX";
				break;
			case 8:
				string += "LXXX";
				break;
			case 9:
				string += "XC";
				break;
//			case 0: // only if input = 100
//				string += "C";
//				break;
		}
		
		switch (n % 10) {
			case 1: 
				string += "I";
				break;
			case 2:
				string += "II";
				break;
			case 3:
				string += "III";
				break;
			case 4:
				string += "IV";
				break;
			case 5:
				string += "V";
				break;
			case 6:
				string += "VI";
				break;
			case 7:
				string += "VII";
				break;
			case 8:
				string += "VIII";
				break;
			case 9:
				string += "IX";	
				break;
		}
		
		return string;
	}
}
