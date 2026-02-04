package recurssion.recurssionOne;

public class MyAtoi {

    public static int myatoi(String str) {
        // 1. Handle empty or null strings
        if (str == null) return 0;

        str = str.trim();

        if (str.length() == 0) return 0;

        int i = 0;
        int sign = 1;
        long res = 0;
        int n = str.length();

        // 2. Handle Signs (+ or -
        // Check first character for sign
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            sign = 1;
            i++;
        }

        // 3. Process Digits
        while (i < n) {
            char ch = str.charAt(i);

            // If character is NOT a digit, stop immediately (break)
            if (ch < '0' || ch > '9') {
                break;
            }

            // Accumulate result
            res = res * 10 + (ch - '0');

            // 4. Check for Overflow/Underflow
            // We check this inside the loop before casting to int
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && (-1 * res) < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++; // Move to next character
        }

        return (int) (res * sign);
    }

    public static void main(String[] args) {
        // Test cases to verify the code
        System.out.println(myatoi("42"));           // Output: 42
        System.out.println(myatoi("   -42"));       // Output: -42
        System.out.println(myatoi("4193 with words")); // Output: 4193
        System.out.println(myatoi("words and 987"));   // Output: 0
        System.out.println(myatoi("-91283472332"));    // Output: -2147483648 (Min Value)
    }
}