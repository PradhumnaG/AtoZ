package string;
import java.io.*;
import java.util.*;
public class AddingTwoString


{

    static String[] diffBetweenTwoStrings(String source, String target) {
        List<String> deleted = new ArrayList<>();
        List<String> inserted = new ArrayList<>();

        int i = 0, j = 0;
        while (i < source.length() && j < target.length() && source.charAt(i) == target.charAt(j)) {
            i++;
            j++;
        }

        // Collect deleted chars from source
        while (i < source.length()) {
            deleted.add(source.substring(i, i + 1));
            i++;
        }

        // Collect inserted chars from target
        while (j < target.length()) {
            inserted.add(target.substring(j, j + 1));
            j++;
        }
//
        return new String[]{String.join("", deleted), String.join("", inserted)};
    }

    public static void main(String[] args) {
        String source = "ABCDEFG";
        String target = "ABDFFGH";
        String[] result = diffBetweenTwoStrings(source, target);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}


