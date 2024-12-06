import java.util.Scanner;

public class ThoseDarnedDoors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = 0;
		
		boolean locker[] = new boolean[101]; // populated by default with "false"
		// false = closed door
		// true = open door
		
		int numberOfStudents = input.nextInt();
		for (int x = 0; x < numberOfStudents; x++) {
			number = input.nextInt();
			
			for (int doorNumber = 1; doorNumber <= 100; doorNumber += number) {
				locker[doorNumber] = !locker[doorNumber]; // flip boolean value
			}
		}

		for (int i = 1; i<= 100; i++) {
			if (locker[i] == true) {
				System.out.print("O");
			} else {
				System.out.print("C");
			}
		}
	}

}
