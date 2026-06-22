package DAY22;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day22Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Day 22: String Operations =====");

        // 1. Check Palindrome String (Q85)
        System.out.print("\nEnter a string to check for palindrome: ");
        String palindromeInput = scanner.nextLine();
        if (isPalindrome(palindromeInput)) {
            System.out.println("\"" + palindromeInput + "\" is a palindrome.");
        } else {
            System.out.println("\"" + palindromeInput + "\" is not a palindrome.");
        }

        // 2. Count Words in a Sentence (Q86)
        System.out.print("\nEnter a sentence to count words: ");
        String sentenceInput = scanner.nextLine();
        int wordCount = countWords(sentenceInput);
        System.out.println("Total word count: " + wordCount);

        // 3. Character Frequency (Q87)
        System.out.print("\nEnter a string to find character frequencies: ");
        String freqInput = scanner.nextLine();
        printCharacterFrequency(freqInput);

        // 4. Remove Spaces from String (Q88)
        System.out.print("\nEnter a string with spaces to remove: ");
        String spacesInput = scanner.nextLine();
        String noSpaces = removeSpaces(spacesInput);
        System.out.println("String after removing spaces: \"" + noSpaces + "\"");

        scanner.close();
    }

    /**
     * Q85: Check whether a string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        // Clean the string (optional: ignore case/non-alphanumeric depending on preference)
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Q86: Count words in a sentence.
     */
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        // Split by one or more whitespace characters
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    /**
     * Q87: Find frequency of each character in a string.
     */
    public static void printCharacterFrequency(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Empty string provided.");
            return;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Character Frequencies:");
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            // Highlighting spaces explicitly for clarity if present
            if (entry.getKey() == ' ') {
                System.out.println("  ' ' (space) : " + entry.getValue());
            } else {
                System.out.println("  " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    /**
     * Q88: Remove all spaces from a string.
     */
    public static String removeSpaces(String str) {
        if (str == null) {
            return null;
        }
        // Replace all whitespace characters with an empty string
        return str.replaceAll("\\s", "");
    }
}
