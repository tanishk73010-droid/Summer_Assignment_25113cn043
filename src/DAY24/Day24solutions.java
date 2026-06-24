package DAY24;

import java.util.LinkedHashSet;

public class Day24solutions {

    public static void main(String[] args) {
        System.out.println("--- Day 24: String Programming Problems --- \n");

        // Q93: Check String Rotation
        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println("[Q93] Is '" + str2 + "' a rotation of '" + str1 + "'? " + isRotation(str1, str2));

        // Q94: Compress a String
        String uncompressed = "aabcccccaaa";
        System.out.println("[Q94] Compressed version of '" + uncompressed + "': " + compressString(uncompressed));

        // Q95: Find Longest Word
        String sentence = "Write a program to find the longest word in this sentence.";
        System.out.println("[Q95] Longest word in sentence: \"" + findLongestWord(sentence) + "\"");

        // Q96: Remove Duplicate Characters
        String duplicateStr = "programming";
        System.out.println("[Q96] String after removing duplicates from '" + duplicateStr + "': " + removeDuplicates(duplicateStr));
    }

    /**
     * Q93: Write a program to Check string rotation.
     * Company Info: Microsoft, Adobe, Paytm
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        // If s2 is a rotation of s1, it must be a substring of s1 concatenated with itself
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }

    /**
     * Q94: Write a program to Compress a string (Run-length encoding).
     * Company Info: Microsoft, Adobe, Paytm
     */
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            // Check if the next character is the same as the current one
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i)).append(count);
                count = 1; // Reset counter
            }
        }

        // Return the compressed string only if it's shorter than the original
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    /**
     * Q95: Write a program to Find longest word.
     * Company Info: TCS, Infosys, Wipro
     */
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        // Split by spaces and remove basic punctuation marks
        String[] words = sentence.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    /**
     * Q96: Write a program to Remove duplicate characters.
     * Company Info: Microsoft, Adobe, Paytm
     */
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Use LinkedHashSet to maintain insertion order while eliminating duplicates
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : set) {
            sb.append(ch);
        }
        return sb.toString();
    }
}