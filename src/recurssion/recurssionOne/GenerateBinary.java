package recurssion.recurssionOne;

 class BinaryGenerator {

    public static void main(String[] args) {
        int n = 3; // Change this for different lengths
        generateBinary("", n);
    }


    public static void generateBinary(String current, int n) {

        if (current.length() == n) {
            System.out.println(current);
            return;
        }


        generateBinary(current + "0", n);

        // Choice 2: Append '1' and recurse
        generateBinary(current + "1", n);
    }
}
