import java.util.Scanner;

public class HashTable {

	public static void main(String[] args) {
		System.out.print("Input string: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		char[] stringChars = s.toCharArray();
		
		int hashCode = 0;
		for (int i = 0; i < stringChars.length; i++) {
			hashCode += stringChars[i] * (i + 1);
		}
		System.out.println("Hash: " + hashCode);
		
		String[][] manta = new String[40000][40000];
		for (int i = 0; i > -1; i++) {
			if (manta[hashCode][i] == "") {
				manta[hashCode][i] = s;
				break;
			}
		}
	}

}
