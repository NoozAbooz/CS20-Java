import java.io.*;
import java.util.*;


public class FactorSquares {
	public static long sumOfSqOfFactors(int n) {
		int[] manta = new int[n+1];
		int index = 0;
		
		for (int i = 1; i < n+1; i++) {
            if (n % i == 0) {
                manta[index] = i;
                index++;
            }
        }
		
		long sum = 0;
		
		for (int i = 0; i < manta.length; i++) {
			if (manta[i] != 0) {
				sum += Math.pow(manta[i], 2);
				//System.out.println(manta[i]);
			}
		}
		
		return sum;
	}
	
	public static boolean isPrime(long n) {
		if (n <= 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 ) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		int n = input.nextInt();
//		System.out.println(sumOfSqOfFactors(n));
		
//		//q1
//		int m = 0;
//		for (int i = 1; i < 101; i++) {
//			if (sumOfSqOfFactors(i) < sumOfSqOfFactors(i - 1)) {
//				m++;
//			}
//		}
//		System.out.println("M = " + m);
		
		
//		n = 2*3*5*7*11*13*17*19*23*29;
//		System.out.println(sumOfSqOfFactors(n));
		
		
		//q3
		for (int k = 1; k < 10000000; k++) {
			if (isPrime(sumOfSqOfFactors(k))) {
				System.out.println(k + " so f(k) = " + sumOfSqOfFactors(k));
			}
		}
	}

}
