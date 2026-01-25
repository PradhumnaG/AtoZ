package recurssion.recurssionOne;

public class CountGoodNumber {

    // Standard Modulo constant for LeetCode problems (10^9 + 7)
    // Note: 10e9 is a double representing 10^10, which is too large for an int.
    static int mod = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Even indices (0, 2, 4...) can hold 0, 2, 4, 6, 8 (5 options)
        // There are (n + 1) / 2 even indices.
        long evenCount = pow(5, (n + 1) / 2);

        // Odd indices (1, 3, 5...) can hold 2, 3, 5, 7 (4 options)
        // There are n / 2 odd indices.
        long primeCount = pow(4, n / 2);

        // Multiply results and take modulo
        long res = (evenCount * primeCount) % mod;

        return (int) res;
    }

    // Helper method for Modular Exponentiation
    // Time Complexity: O(log y)
    public long pow(long x, long y) {
        if (y == 0) return 1;

        // Calculate power for y/2 (Divide and Conquer)
        long res = pow(x, y / 2);

        // Square the result: (x^(y/2))^2 = x^y (if y is even)
        res = (res * res) % mod;

        // If y is even, we are done
        if (y % 2 == 0) {
            return res;
        }
        // If y is odd, multiply by x one more time
        else {
            return (res * x) % mod;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CountGoodNumber solver = new CountGoodNumber();
        long n = 50;
        System.out.println("Result for n=" + n + ": " + solver.countGoodNumbers(n));
    }
}