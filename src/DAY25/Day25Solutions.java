package DAY25;
import java.util.Arrays;

public class Day25Solutions {

    public static void main(String[] args) {
        System.out.println("--- Day 25 Program Solutions ---\n");

        // --- Q97: Merge Two Sorted Arrays ---
        System.out.println("Q97: Merge Two Sorted Arrays");
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Merged Sorted Array: " + Arrays.toString(merged));
        System.out.println("\n---------------------------------------\n");


        // --- Q98: Find Common Characters in Strings ---
        System.out.println("Q98: Find Common Characters in Strings");
        String str1 = "programming";
        String str2 = "gaming";
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        System.out.print("Common Characters: ");
        printCommonCharacters(str1, str2);
        System.out.println("\n---------------------------------------\n");


        // --- Q99: Sort Names Alphabetically ---
        System.out.println("Q99: Sort Names Alphabetically");
        String[] names = {"Rahul", "Amit", "Vijay", "Ananya", "Deepak"};
        System.out.println("Original Names: " + Arrays.toString(names));
        sortNamesAlphabetically(names);
        System.out.println("Alphabetically Sorted: " + Arrays.toString(names));
        System.out.println("\n---------------------------------------\n");


        // --- Q100: Sort Words by Length ---
        System.out.println("Q100: Sort Words by Length");
        String[] words = {"Elephant", "Cat", "Crocodile", "Dog", "Monkey"};
        System.out.println("Original Words: " + Arrays.toString(words));
        sortWordsByLength(words);
        System.out.println("Sorted by Length: " + Arrays.toString(words));
    }

    /**
     * Q97: Merge two sorted arrays into a single sorted array.
     * Time Complexity: O(n + m)
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Traverse both arrays and copy the smaller element
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1, if any
        while (i < n1) {
            merged[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2, if any
        while (j < n2) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    /**
     * Q98: Find and print common characters between two strings.
     * Uses a frequency array approach to handle duplicate occurrences correctly.
     */
    public static void printCommonCharacters(String str1, String str2) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        // Count frequencies for both strings
        for (char ch : str1.toCharArray()) {
            count1[ch]++;
        }
        for (char ch : str2.toCharArray()) {
            count2[ch]++;
        }

        // Print the minimum intersection count for each character
        for (int i = 0; i < 256; i++) {
            if (count1[i] > 0 && count2[i] > 0) {
                int minOccurrences = Math.min(count1[i], count2[i]);
                for (int m = 0; m < minOccurrences; m++) {
                    System.out.print((char) i + " ");
                }
            }
        }
        System.out.println();
    }

    /**
     * Q99: Sort an array of strings alphabetically.
     * Implemented using a standard Bubble Sort routine for conceptual clarity.
     */
    public static void sortNamesAlphabetically(String[] names) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // compareTo() returns > 0 if names[j] is lexicographically greater than names[j+1]
                if (names[j].compareTo(names[j + 1]) > 0) {
                    // Swap strings
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Q100: Sort words by their length.
     * If lengths are equal, it maintains their relative order.
     */
    public static void sortWordsByLength(String[] words) {
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    // Swap elements
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }
}