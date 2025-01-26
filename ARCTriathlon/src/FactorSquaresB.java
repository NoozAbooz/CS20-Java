import java.math.BigInteger;

public class FactorSquaresB {
    public static void main(String[] args) {
        // List of the first 10 primes
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        // Calculate the powers of 2 and 5 in f(n)
        int powerOf2 = calculatePowerInFactorial(primes, 2);
        int powerOf5 = calculatePowerInFactorial(primes, 5);

        // Number of trailing zeroes is the minimum of the two
        int trailingZeroes = Math.min(powerOf2, powerOf5);

        System.out.println("Number of trailing zeroes in f(n): " + trailingZeroes);
    }

    // Function to calculate the power of a prime factor in f(n)
    private static int calculatePowerInFactorial(int[] primes, int primeFactor) {
        int totalPower = 0;

        // Iterate through each prime in the product
        for (int p : primes) {
            // Calculate the numerator: p^(2 * (1 + 1)) - 1
            BigInteger numerator = BigInteger.valueOf(p).pow(4).subtract(BigInteger.ONE);

            // Calculate the denominator: p^2 - 1
            BigInteger denominator = BigInteger.valueOf(p * p - 1);

            // Divide numerator by denominator
            BigInteger fraction = numerator.divide(denominator);

            // Count the power of the given primeFactor (2 or 5) in the fraction
            totalPower += countPrimeFactors(fraction, primeFactor);
        }

        return totalPower;
    }

    // Function to count the power of a prime in a number
    private static int countPrimeFactors(BigInteger number, int primeFactor) {
        int count = 0;
        BigInteger prime = BigInteger.valueOf(primeFactor);

        // Keep dividing by the primeFactor as long as it's divisible
        while (number.mod(prime).equals(BigInteger.ZERO)) {
            number = number.divide(prime);
            count++;
        }

        return count;
    }
}
