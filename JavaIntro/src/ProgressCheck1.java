import java.util.Scanner;

public class ProgressCheck1 {

	public static int errorTrapInput(String message) {
		int data = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.println(message);
		
		do {
			try {
				data = input.nextInt();
			}
			catch (Exception e) {
				System.out.println("Error");
				input.nextLine();
			}
		} while (data == 0);
		
		return data;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int maxNumber = 0;
		int factor1 = 1;
		int factor2 = 1;
		
		maxNumber = errorTrapInput("Max number?");
		factor1 = errorTrapInput("Factor 1?");
		factor2 = errorTrapInput("Factor 2?");
		
		for (int i = 1; i <= maxNumber; i++) {
			if (i % factor1 == 0 && i % factor2 == 0) {
				System.out.println(i);
			}
		}
	}

}
