 
public class WordsFromLetters {

	public static void main(String[] args) {
		System.out.println(checkLettersV2("shoes", "hosed"));
	}
	
	public static boolean checkLetters(String str1, String str2) {
		boolean state = true;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
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
				state = false;
			}
		}
		return state;
	}
	
	// mr chow's hash table version, it must be an anagram for this to work
	public static boolean checkLettersV2(String str1, String str2) {
		int[] count = new int[123];
		
		for (int x = 0; x < str1.length(); x++) { //essentially the ascii letter value corresponds to index
			count[ str1.charAt(x) ]++; // add 1 to the element in each letter's ascii position on the arr
		}
		
		for (int x = 0; x < str2.length(); x++) {
			count[ str2.charAt(x) ]--; // take 1 away from indexes
		}
		
		// if any element is not 0, its not anagram 
		for (int x : count) {
			if (x != 0) {
				return false;
			}
		}
		return true;
	}

}


