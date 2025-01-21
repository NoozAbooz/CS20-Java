import java.io.*;
import java.util.*;

public class MarkingMadness {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		// papers marked on day N
		System.out.println(n);
		
		// papers marked up to day N
			// sum arithmetic sum formula
		System.out.println(n * (1 + n) / 2);
		
		// Which day did professor who marks on day N start marking
			// total M + 1 professors
			// professor marking on day k = ((k-1) mod (M + 1)) + 1
		System.out.println((n - 1) % (m + 1) + 1);
	}

}
