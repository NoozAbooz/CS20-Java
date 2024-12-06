
public class SieveofEratosthenes {

	public static void main(String[] args) {
		int limit = myTools.userInput("upper limit to generate?", 3, 1000000);
		int[] manta = new int[limit - 1];
		
		populateSequential(manta, limit);
		eliminate(manta);
		display(manta);
		
		int input = (int)myTools.userInput("Input a number to check: ");
		System.out.println(isPrime(manta, input));
	}
	
	public static void populateSequential(int[] array, int a) {
		for (int i = 0; i < (a - 1); i++) {
			array[i] = (2 + i); // offset
		}
	}
	
	public static void display(int[] array) { // pretty formatting :D
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				if (array[i] < 10) {
					System.out.print(array[i] + "       ");
				} else if (array[i] < 100) {
					System.out.print(array[i] + "      ");
				} else if (array[i] < 1000) {
					System.out.print(array[i] + "     ");
				} else if (array[i] < 10000) {
					System.out.print(array[i] + "    ");
				} else if (array[i] < 100000) {
					System.out.print(array[i] + "   ");
				} else {
					System.out.print(array[i] + "  ");
				}
				
				if ((array[i] + 1) % 10 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
	}
	
	public static void eliminate(int[] array) {	
		// redundant, this code has been merged into the loop below
//		for (int i = 1; i < array.length; i++) { // take out everything divisible by 2 (even numbers)
//			if (i % 2 == 0) {
//				array[i] = 0;
//			}
//		}
		
		for (int i = 0; i < array.length; i++) {
			for (int k = 1; k < array.length; k++) {
				int currentPrime = array[i];
				int value = array[k]; 
				if ((currentPrime != 0) && (value != currentPrime) && (value % currentPrime == 0)) {
					array[k] = 0; // eliminate all numbers that can be divided by a number earlier in the arr.
				}
			}
		}
	}
	
	public static String isPrime(int[] array, int num) {
		for (int i = 0; i < array.length; i++) { // mm yes i love searching a 200000-number long array with a loop
			if (array[i] == num) {
				return "prime";
			}
		}
		
		return "not prime";
	}
}

