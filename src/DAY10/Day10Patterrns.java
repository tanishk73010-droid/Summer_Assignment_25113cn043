package DAY10;

import java.util.Scanner;

public class Day10Patterrns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 10 Pattern Printing Menu ---");
            System.out.println("1. Q37: Star Pyramid");
            System.out.println("2. Q38: Reverse Pyramid");
            System.out.println("3. Q39: Number Pyramid");
            System.out.println("4. Q40: Character Pyramid");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printStarPyramid(5);
                    break;
                case 2:
                    printReversePyramid(5);
                    break;
                case 3:
                    printNumberPyramid(5);
                    break;
                case 4:
                    printCharacterPyramid(5);
                    break;
                case 5:
                    System.out.println("Exiting... Happy Coding!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Q37: Star Pyramid
    //     *
    //    ***
    //   *****
    //  *******
    // *********
    public static void printStarPyramid(int rows) {
        System.out.println("\n--- Q37: Star Pyramid ---");
        for (int i = 1; i <= rows; i++) {
            // Printing spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Printing stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q38: Reverse Pyramid
    // *********
    //  *******
    //   *****
    //    ***
    //     *
    public static void printReversePyramid(int rows) {
        System.out.println("\n--- Q38: Reverse Pyramid ---");
        for (int i = rows; i >= 1; i--) {
            // Printing spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Printing stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q39: Number Pyramid
    //     1
    //    121
    //   12321
    //  1234321
    // 123454321
    public static void printNumberPyramid(int rows) {
        System.out.println("\n--- Q39: Number Pyramid ---");
        for (int i = 1; i <= rows; i++) {
            // Printing spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Printing increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Printing decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Q40: Character Pyramid
    //      A
    //     ABA
    //    ABCBA
    //   ABCDCBA
    //  ABCDEDCBA
    public static void printCharacterPyramid(int rows) {
        System.out.println("\n--- Q40: Character Pyramid ---");
        for (int i = 1; i <= rows; i++) {
            // Printing spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Printing increasing characters
            char ch = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++);
            }
            // Printing decreasing characters
            ch -= 2; // Step back to the previous character
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(ch--);
            }
            System.out.println();
        }
    }
}
