package recurssion.recurssionOne;

class Pow {

    // This is your Solution class structure
    static class Solution {
        public double myPow(double x, int n) {
            // Convert n to long to prevent overflow when n = Integer.MIN_VALUE
            return binaryexp(x, n);
        }

        private double binaryexp(double x, long n) {
            // Base Case: Anything to the power of 0 is 1
            if (n == 0) {
                return 1;
            }

            // Handling Negative Powers: x^-n = 1 / x^n
            if (n < 0) {
                // Note: We pass -n to make the exponent positive for the calculation
                return 1.0 / binaryexp(x, -n);
            }

            // Recursive Logic (Binary Exponentiation)
            // If n is Odd: x^n = x * (x^2) ^ ((n-1)/2)
            if (n % 2 == 1) {
                return x * binaryexp(x * x, (n - 1) / 2);
            }
            // If n is Even: x^n = (x^2) ^ (n/2)
            else {
                return binaryexp(x * x, n / 2);
            }
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Positive power
        double x1 = 2.0;
        int n1 = -10;
        System.out.println("2.0 ^ 10 = " + solver.myPow(x1, n1)); // Expected: 1024.0

        // Test Case 2: Negative power
        double x2 = 2.0;
        int n2 = -2;
        System.out.println("2.0 ^ -2 = " + solver.myPow(x2, n2)); // Expected: 0.25

        // Test Case 3: Zero power
        double x3 = 5.67;
        int n3 = 0;
        System.out.println("5.67 ^ 0 = " + solver.myPow(x3, n3)); // Expected: 1.0

        // Test Case 4: Edge case (Integer.MIN_VALUE)
        // If we didn't use 'long', this would overflow and crash
        double x4 = 2.0;
        int n4 = -2147483648;
        System.out.println("2.0 ^ MinValue = " + solver.myPow(x4, n4)); // Expected: 0.0
    }
}