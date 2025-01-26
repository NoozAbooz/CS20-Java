import java.io.*;
import java.util.*;

public class MindyMath {

	/**
	 * Count how many "inferior" groups of 3 exist among the 6 consecutive numbers [n, n+1, ..., n+5].
	 * A group of 3 is "inferior" if its product <= the product of the remaining 3.
	 */
	public static void countInferior(long n) {
	    // Build array of 6 consecutive longs
	    long[] arr = new long[6];
	    for (int i = 0; i < 6; i++) {
	        arr[i] = n + i;  // assumes no overflow for n+5
	    }
    
	    // We'll do a triple nested loop over i, j, k with 0 <= i < j < k < 6
	    for (int i = 0; i < 6; i++) {
	        for (int j = i + 1; j < 6; j++) {
	            for (int k = j + 1; k < 6; k++) {
	                // Product of chosen triple
	                long prodFirst = arr[i] * arr[j] * arr[k];
    
	                // Identify the 3 "remaining" indices
	                // We can do that by collecting whichever indices are not i, j, k
	                // For simplicity, a small loop from 0..5:
	                long prodSecond = 1;
	                for (int m = 0; m < 6; m++) {
	                    if (m != i && m != j && m != k) {
	                        prodSecond *= arr[m];
	                    }
	                }
    
	                // Now check if prodFirst <= prodSecond
	                if (prodFirst <= prodSecond) {
	                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
	                }
	            }
	        }
	    }
	}
	
    /**
     * Count how many "equal" groups of 3 exist among the 6 consecutive numbers [n^k, n^k+1, ..., n^k+5].
     * A group of 3 is "equal" if its product == the product of the remaining 3.
     */
    public static int countEqual(long n, int k) {
        // Compute n^k in a basic way (watch for overflow if n and k are large)
        long start = 1;
        for (int i = 0; i < k; i++) {
            start *= n; 
        }
        // Now build array of 6 consecutive numbers [start, start+1, ..., start+5]
        long[] arr = new long[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = start + i;  // again, watch for overflow if start + 5 is too large
        }

        int count = 0;

        // Triple nested loop for 3-combinations from the 6
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int m = j + 1; m < 6; m++) {
                    // product of arr[i], arr[j], arr[m]
                    long prodFirst = arr[i] * arr[j] * arr[m];

                    // product of the complementary group
                    long prodSecond = 1;
                    for (int x = 0; x < 6; x++) {
                        if (x != i && x != j && x != m) {
                            prodSecond *= arr[x];
                        }
                    }

                    // Check for equality
                    if (prodFirst == prodSecond) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		int k = input.nextInt();
		countInferior(n);
		System.out.println(countEqual(n, k));
	}

}
