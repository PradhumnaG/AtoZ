package recurssion.recurssionOne;

 class BinaryGenerator {

    public static void main(String[] args) {
        int n = 3; // Change this for different lengths
        generateBinary("", n);
    }


    public static void generateBinary(String current, int n) {
        // Base case: if the string has reached length n, print it
        if (current.length() == n) {
            System.out.println(current);
            return;
        }

        // Choice 1: Append '0' and recurse
        generateBinary(current + "0", n);

        // Choice 2: Append '1' and recurse
        generateBinary(current + "1", n);
    }
}
