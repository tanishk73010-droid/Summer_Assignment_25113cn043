package DAY23;

import java.util.Scanner;

public class Day23Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("       DAY 23 PRACTICE MENU      ");
            System.out.println("=================================");
            System.out.println("1. Find First Non-Repeating Character (Q89)");
            System.out.println("2. Find First Repeating Character (Q90)");
            System.out.println("3. Check Anagram Strings (Q91)");
            System.out.println("4. Find Maximum Occurring Character (Q92)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Exiting.");
                break;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left by nextInt()

            switch (choice) {
                case 1:
                    findFirstNonRepeating(scanner);
                    break;
                case 2:
                    findFirstRepeating(scanner);
                    break;
                case 3:
                    checkAnagram(scanner);
                    break;
                case 4:
                    findMaxOccurring(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program. Happy Coding!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

    // Q89: Find first non-repeating character
    private static void findFirstNonRepeating(Scanner scanner) {
        System.out.print("\nEnter a string: ");
        String str = scanner.nextLine();
        int[] count = new int[256];

        // Build frequency counter array
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        // Traverse the string to find the first character with a count of 1
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                System.out.println("The first non-repeating character is: '" + str.charAt(i) + "'");
                return;
            }
        }
        System.out.println("All characters repeat or the string is empty.");
    }

    // Q90: Find first repeating character
    private static void findFirstRepeating(Scanner scanner) {
        System.out.print("\nEnter a string: ");
        String str = scanner.nextLine();
        int[] count = new int[256];

        // Find the first character that already exists in our frequency array
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (count[ch] == 1) {
                System.out.println("The first repeating character is: '" + ch + "'");
                return;
            }
            count[ch] = 1;
        }
        System.out.println("No repeating characters found.");
    }

    // Q91: Check anagram strings
    private static void checkAnagram(Scanner scanner) {
        System.out.print("\nEnter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // If lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            System.out.println("The strings are NOT anagrams.");
            return;
        }

        int[] count = new int[256];

        // Increment count for first string, decrement for second string
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        // If all values are 0, it means the strings are anagrams
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                System.out.println("The strings are NOT anagrams.");
                return;
            }
        }
        System.out.println("The strings are anagrams.");
    }

    // Q92: Find maximum occurring character
    private static void findMaxOccurring(Scanner scanner) {
        System.out.print("\nEnter a string: ");
        String str = scanner.nextLine();

        if (str.isEmpty()) {
            System.out.println("The string is empty.");
            return;
        }

        int[] count = new int[256];
        int max = -1;
        char maxChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }

        System.out.println("The maximum occurring character is '" + maxChar + "' (Repeated " + max + " times).");
    }
}
