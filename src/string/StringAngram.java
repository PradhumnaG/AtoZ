package string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAngram {

    // Your perfectly correct algorithm
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        Map<String, Integer> signatureCounts = new HashMap<>();

        for (String word : dictionary) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            signatureCounts.put(signature, signatureCounts.getOrDefault(signature, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (String q : query) {
            char[] chars = q.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            result.add(signatureCounts.getOrDefault(signature, 0));
        }

        return result;
    }

    // NEW: The main method to test your code
    public static void main(String[] args) {
        // 1. Create some sample dictionary words
        List<String> dictionary = Arrays.asList("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits");

        // 2. Create some sample queries
        List<String> query = Arrays.asList("a", "nark", "bs", "hack", "stair");

        // 3. Run your function
        List<Integer> answers = stringAnagram(dictionary, query);

        // 4. Print the results to the console
        System.out.println("Anagram Counts: " + answers);
        // Expected Output: [2, 2, 0, 3, 1]
    }
}