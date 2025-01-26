import java.io.*;
import java.util.*;

public class LuotongsLuxate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String sShifted = s;
		int n = input.nextInt();
		
		// cyclic shift
		for (int i = 0; i < n; i++) {
			sShifted = sShifted.substring(1) + sShifted.charAt(0);
		}
		
		// count letters in same positon
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sShifted.charAt(i)) {
				counter++;
			}
		}
		System.out.println(counter);
	}

}
