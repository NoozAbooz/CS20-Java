import java.util.Arrays;

public class SkillBuilding {

	public static void main(String[] args) {
		int array[] = new int[100];
		int userChoice = 0;
		
		do {
			userChoice = menu();
			
			switch (userChoice) {
			case 1:
				populateRandom(array);
				break;
			case 2:
				populateSequential(array);
				break;
			case 3:
				display(array);
				break;
			case 4:
				shuffle(array);
				break;
			case 5:
				System.out.println(findOccurrence(array, (int)myTools.userInput("Number to find index of: ")));
				break;
			case 6:
				System.out.println(ascending(array));
				break;
			case 7:
				System.out.println(shuffleSort(array));
				break;
			case 8:
				System.out.println(lowestValue(array));
				break;
			case 9:
				System.out.println(highestValue(array));
				break;
			case 10:
				System.out.println(countOccurrences(array, (int)myTools.userInput("Number to count occurrences of: ")));
				break;
			case 11:
				findAndReplace(array, (int)myTools.userInput("Num to find"), (int)myTools.userInput("Num to replace"));
			case 12:
				System.out.println(tenConsecutiveSum(array));
			}
		} while (userChoice != 0);
	}

	public static int menu() {
		System.out.println("0. Exit Program");
		System.out.println("1. Populate array randomly");
		System.out.println("2. Populate array sequentially from 1 - 100");
		System.out.println("3. Display array");
		System.out.println("4. Shuffle array");
		System.out.println("5. Find index of first occurrence");
		System.out.println("6. Check ascending");
		System.out.println("7. Shuffle sort");
		System.out.println("8. Lowest value");
		System.out.println("9. Highest value");
		System.out.println("10. How many occurrences");
		System.out.println("11. Find and replace");
		System.out.println("12. Greatest sum of 10 consecutive indexes");
		return myTools.userInput(0, 12);
	}
	
	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] < 10) {
				System.out.print(array[i] + "   ");
			} else if (array[i] < 100) {
				System.out.print(array[i] + "  ");
			} else {
				System.out.print(array[i] + " ");
			}
			
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
	
	public static void populateRandom(int[] array) {
		for (int i = 0; i < 100; i++) {
			array[i] = myTools.random(1, 100);
		}
	}
	
	public static void populateSequential(int[] array) {
		for (int i = 0; i < 100; i++) {
			array[i] = (i + 1);
		}
	}
	
	public static void shuffle(int[] array) {		
		for (int i = 0; i < array.length; i++) { // go in sequence down the array and swap with random index
			int targetIndex = myTools.random(0, array.length - 1);
			int placeholderValue = array[i];
			array[i] = array[targetIndex];
			array[targetIndex] = placeholderValue;
		}
	}
	
	public static int findOccurrence(int[] array, int number) { // return index of first occurrence
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static boolean ascending(int[] array) { // boolean ascending order
		boolean isAscending = true;
		int previousValue = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] != (previousValue + 1)) {
				isAscending = false; // set to false the first iteration where it is not ascending and immediately exit
				break;
			}
			previousValue = array[i];
		}
		return isAscending;
	}
	
	public static boolean shuffleSort(int[] array) { // check if sorted by random shuffle
		boolean isAscending = false;
		for (int i = 0; i < 10000; i++) {
			shuffle(array);
			if (ascending(array) == true) {
				isAscending = true;
				break;
			}
		}
		return isAscending;
	}
	
	public static int lowestValue(int[] array) { // find lowest value
		int value = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < value) {
				value = array[i];
			}
		}
		return value;
	}
	
	public static int highestValue(int[] array) { // find highest values
		int value = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > value) {
				value = array[i];
			}
		}
		return value;
	}
	
	public static int countOccurrences(int[] array, int number) { // count of all occurances
		int occurances = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				occurances++;
			}
		}
		return occurances;
	}
	
	public static void findAndReplace(int[] array, int number1, int number2) { // replace num1 with 2num2
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number1) {
				array[i] = number2;
			}
		}
	}
	
	public static int tenConsecutiveSum(int[] array) {
	// Algorithm that finds the section of the array with 10 consecutive indexes(addresses) 
	// that has the greatest sum. Returns the smallest index.
		int smallestIndex = 0; // smallest index of the sum with highest value
		int greatestSum = 0; // highest possible value
		
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = 1; j < 10; j++) { // add up to the next 9 numbers
				if (!((i + j) > array.length)) { // prevent accessing out of bounds index
					sum += array[i + j]; // if not out of bounds
				} // otherwise do not do anything to sum
			}
			
			if (sum > greatestSum) {
				smallestIndex = i;
				greatestSum = sum;
			}
		}
		return smallestIndex;
	}
}
 