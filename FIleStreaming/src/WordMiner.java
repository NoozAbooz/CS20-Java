import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordMiner {
	public static boolean isValid(String word){
		boolean isValid = true;
		if (word.length() >= 3 && word.length() <= 6) {
			char[] arr = word.toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				if (!(arr[i] >= 97 && arr[i] <= 122)) {
					isValid = false;
				}
			}
		} else {
			isValid = false;
		}
		
		return isValid;
	}
	
	public static int findHashCode(String word) {
		int hashCode = 0;
		char[] stringChars = word.toCharArray();
		for (int i = 0; i < stringChars.length; i++) {
			hashCode += stringChars[i] * (i + 1);
		}
		return hashCode;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner infile = new Scanner( new File("dictionary2.txt") );
		String[][] hashTable = new String[10000][50];
		
		while (infile.hasNext()) {
			String word = infile.next();
			if (isValid(word)) {
				System.out.println(word);
				
				int hashCode = findHashCode(word);
				if (hashCode > 10000) { // ensure it fits in the array, this is fine because we accommodate for collisions
					hashCode = hashCode % 10000;
				}
				
				for (int i = 0; i < hashTable[0].length; i++) { // if spot taken, write to next available column
					if (hashTable[hashCode][i] == null) {
						hashTable[hashCode][i] = word;
						break;
					}
				}
			}
		}
		
		File outfile = new File("output.txt"); // write unique words to file
		PrintWriter pw = new PrintWriter(outfile);
		for (int i = 0; i < hashTable.length; i++) {
			for (int j = 0; j < hashTable[0].length; j++) {
				if (hashTable[i][j] != null) {
					pw.println(hashTable[i][j]);
				}
			}
		}
		
		pw.close(); // must remember to close
	}

}
