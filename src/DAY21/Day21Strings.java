package DAY21;

import java.util.Scanner;

public class Day21Strings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 21 String Operations Menu ---");
            System.out.println("1. Find String Length without length() (Q81)");
            System.out.println("2. Reverse a String (Q82)");
            System.out.println("3. Count Vowels and Consonants (Q83)");
            System.out.println("4. Convert Lowercase to Uppercase (Q84)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left over

            switch (choice) {
                case 1:
                    handleStringLength(scanner);
                    break;
                case 2:
                    handleReverseString(scanner);
                    break;
                case 3:
                    handleCountVowelsConsonants(scanner);
                    break;
                case 4:
                    handleToUpperCase(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Day 21 program. Keep up the great momentum!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Q81: Find string length without using built-in length() method
    private static void handleStringLength(Scanner scanner) {
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        int length = 0;
        // Convert to char array to iterate manually without using .length()
        for (char c : str.toCharArray()) {
            length++;
        }

        System.out.println("Length of the string (calculated manually): " + length);
    }

    // Q82: Reverse a string
    private static void handleReverseString(Scanner scanner) {
        System.out.print("Enter a string to reverse: ");
        String str = scanner.nextLine();

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);
    }

    // Q83: Count vowels and consonants
    private static void handleCountVowelsConsonants(Scanner scanner) {
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        int vowels = 0, consonants = 0;
        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);

            // Check if character is an alphabet letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels count: " + vowels);
        System.out.println("Consonants count: " + consonants);
    }

    // Q84: Convert lowercase to uppercase without built-in toUpperCase()
    private static void handleToUpperCase(Scanner scanner) {
        System.out.print("Enter a string in lowercase/mixed case: ");
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // If the character is lowercase, convert it using ASCII manipulation
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }

        String result = new String(chars);
        System.out.println("Uppercase string: " + result);
    }
}
