import java.util.Scanner;

public class Main {

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
//		int a = errorTrapInput("Number 1?");
//		int b = errorTrapInput("Number 2?");
//	
//		System.out.println(MathOperations.add(a, b));
//		System.out.println(MathOperations.subtract(a, b));
//		System.out.println(MathOperations.multiply(a, b));
//		System.out.println(MathOperations.divide(a, b));
	
//		int n = errorTrapInput("Factorial of?");
//		System.out.println(MethodPractice.calculateFactorial(n));
		
//		int a = errorTrapInput("Number 1?");
//		int b = errorTrapInput("Number 2?");
//		int c = errorTrapInput("Number 3?");
//		System.out.println(MethodPractice.middleValue(a, b, c));
		
//		int n = errorTrapInput("Digit Sum?");
//		System.out.println(MethodPractice.digitSum(n));
		
//		int a = errorTrapInput("Min?");
//		int b = errorTrapInput("Max?");
//		System.out.println(MethodPractice.random(a, b));
		
		System.out.println(MethodPractice.romanNumeral(5));
	}

}
