import java.util.Scanner;

public class StringManipulation {

	// capitalize 1st letter
//	public static void main(String[] args) {		
//		Scanner input = new Scanner(System.in);
//		String text = input.next();
////		
//		// capitalize first letter
////		if (text.charAt(0) >= 97 && text.charAt(0) <= 122) {
////			text = "" + (char)(text.charAt(0) - 32) + text.substring(1);
////		}
////
////		System.out.println(name);
//		
//		if(text.contains("a")) {
//			System.out.println("yes");
//		}
//	}
	
	// arrray to string
//	char[] ch = {'S', 'i', 'g', 'm', 'a'};
//	String str = String.valueOf(ch);
//	System.out.println(str);
	
	// mr. chow's demo for ascii sorting letters in a word
	public static String sortWord(String st) {
		char[] manta = st.toCharArray();
		String sortedWord = "";
		
		for (int q = 0; q < st.length(); q++) {			
			int lowestIndex = 0;
			
			for (int x = 0; x < manta.length; x++) {
				if (manta[x] < manta[lowestIndex]) {
					lowestIndex = x;
				}
			}
			sortedWord += manta[lowestIndex];
			manta[lowestIndex] = '{';
		}
		
		return sortedWord;
	}
	
	// ccc 20' J4 cyclic shift
	public static void cyclicShift() {
		Scanner input = new Scanner(System.in);

		String sentence = input.nextLine();
		String word = input.nextLine();
		    
		boolean found = false;
		for (int x = 0; x < word.length(); x++) {
				
			System.out.println(word);
			
			if (sentence.contains(word)) {
				found = true;
			}
		}
		
		if (found == true) {
		    System.out.println("yes");
		} else {
		    System.out.println("no");
		}
	}

	//This method returns the length of the String, st
	public static int getLength(String st) {
		return st.length();
	}
	//This method returns the number of times a char, ch, appears in the String, st
	public static int letterCount(String st, char ch){
		int counter = 0;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == ch) {
				counter++;
			}
		}
		return counter;
	}
	//This method returns the reverse of the String, st
	public static String reverse(String st) {
		 String reversedStr = "";
		 char tempChar;
		 
		 for (int i = 0; i < st.length(); i++) {
			 tempChar = st.charAt(i);
			 reversedStr = tempChar + reversedStr; // append to beginning instead of end
		 }
		 
		 return reversedStr;
	 }
	//This method returns true if st1 and st2 are anagrams of each other.
	//If they are not anagrams, it returns false
	//The method is case sensitive
	public static boolean isAnagram(String st1, String st2){
		boolean isAnagram = true;
		char[] arr1 = st1.toCharArray();
		char[] arr2 = st2.toCharArray();
		
		if (arr1.length != arr2.length) {
			return false;
		}
		
		for (char c : arr2) { // replace identical characters with '!' and break loop on first instance
			for (int i = 0; i < arr1.length; i++) {
				if (c == arr1[i]) {
					arr1[i] = '!';
					break;
				}
			}
		}
		
		for (char c : arr1) { // double check every single array element
			if (c != '!') {
				isAnagram = false;
			}
		}
		return isAnagram;
	}
	/*This method will return the pig latin version of a word. The pig latin
	version of a word is found by moving the first letter of the word to the
	end of the word and then adding "ay" to it.
	Example: Robin = obinRay;
	Example: Raven = avenRay
	Example: Cyborg = yborgCay;
	*/
	public static String pigLatin(String st) {
		String translatedStr = st.substring(1) + st.charAt(0) + "ay";
		
		return translatedStr;
	}
	/*This method will remove all duplicate characters from a String so that it
	is only made of unique characters. You can assume all characters in the String
	will have ASCII values between 32 and 126 (inclusive)
	Sample Input:
	banana
	Sample Output:
	ban
	*/
	public static String removeDuplicates(String st) {
		String processedStr = "";
		
		for (int i = 0; i < st.length(); i++) {
			boolean hasDuplicate = false;
			for (int k = 0; k < processedStr.length(); k++) {
				if (processedStr.charAt(k) == st.charAt(i)) {
					hasDuplicate = true;
				}
			}
			if (hasDuplicate == false) {
				processedStr = processedStr + st.charAt(i);
			}
		}
		return processedStr;
	}
	/*The following method takes a string of 1's and 0's and compresses it by
	making a new string in the following way:
	1. The new string will start with the first character (either 1 or 0) in the
	string
	2. The next character will be a number showing how many of that digit appeared
	in a row before the opposite digit appeared.
	3. The next character will be a number showing how many of the opposite digit
	appeared in a row before the first digit appeared again.
	4. Go to step 2 and keep repeating until the whole string is compressed.
	Sample input: 111111111111000000001111111110000110001111000
	Sample output: 1 12 8 9 4 2 3 4 3
	*/
	public static String compression(String st) {
		String processedStr = "";
		char firstChar = st.charAt(0);
		char otherChar = Character.forDigit(1 - (st.charAt(0) - '0'), 10); // convert firstChar to int and flip value
		processedStr = processedStr + firstChar;
	
		int i = 0;
		
		do {
			// step 2
			int counter = 0;
			while (st.charAt(i) == firstChar && i < (st.length() - 1)) {
				counter++;
				i++;
				
				// add count for last char since it gets skipped over... HACKY FIX
				counter = (i == st.length() - 1) ? counter + 1 : counter; 
			}
			processedStr = processedStr + " " + counter;
			
			counter = 0;
			// step 3
			while (st.charAt(i) == otherChar && i < (st.length() - 1)) {
				counter++;
				i++;
				
				counter = (i == st.length() - 1) ? counter + 1 : counter;
			}
			processedStr = processedStr + " " + counter;
		} while (i < (st.length() - 1));
			
		return processedStr;
	}


		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		/////////////////////////////////////////
		 //DO NOT EDIT ANY CODE BELOW THIS LINE!//
		 /////////////////////////////////////////
		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testNumber = input.nextInt();
		if(testNumber == 1){
		String st = input.next();
		System.out.println( getLength(st) );
		}
		else if(testNumber == 2){
		String st = input.next();
		System.out.println( letterCount(st, 'p'));
		System.out.println( letterCount(st, 'b'));
		System.out.println( letterCount(st, 'a'));
		}
		else if(testNumber == 3){
		String st = input.next();
		System.out.println( reverse(st) );
		}
		else if(testNumber == 4){
		String s1 = input.next();
		String s2 = input.next();
		System.out.println( isAnagram(s1, s2) );
		}
		else if(testNumber == 5){
		String st = input.next();
		System.out.println( pigLatin(st) );
		}
		else if (testNumber == 6){
		String st = input.next();
		System.out.println( removeDuplicates(st) );
		}
		else if(testNumber == 7){
		String st = input.next();
		System.out.println( compression(st) );
		}



		}
}