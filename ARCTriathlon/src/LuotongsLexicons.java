import java.io.*;
import java.util.*;

public class LuotongsLexicons {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		char manta[] = s.toCharArray();
		char a = input.nextLine().charAt(0);
		char b = input.nextLine().charAt(0);
		
		// replace letters
		int replacementCount = 0;
		for (char j : manta) {
			if (j == a) {
				System.out.print(b); // replace with b
				replacementCount++;
			} else {
				System.out.print(j); // continue
			}
		}
		System.out.println();
		
		// count replacements
		System.out.println(replacementCount);
		
	}

}
