package DAY9;

import java.util.Scanner;

public class Day9Allques {

    // Q33: Function to print reverse star pattern (e.g., *****, ****, ***, **, *)
    public static void printReverseStarPattern(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q34: Function to print reverse number triangle (e.g., 12345, 1234, 123, 12, 1)
    public static void printReverseNumberTriangle(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Q35: Function to print repeated character pattern (e.g., A, BB, CCC, DDDD, EEEEE)
    public static void printRepeatedCharPattern(int rows) {
        char ch = 'A';
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
            }
            ch++; // Move to the next character for the next row
            System.out.println();
        }
    }

    // Q36: Function to print hollow square pattern
    public static void printHollowSquarePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                // Print stars for the first and last rows, and first and last columns
                if (i == 1 || i == rows || j == 1 || j == rows) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display Menu
            System.out.println("\n--- Day 9 Pattern Printing Menu ---");
            System.out.println("1. Q33: Reverse Star Pattern (*****)");
            System.out.println("2. Q34: Reverse Number Triangle (12345)");
            System.out.println("3. Q35: Repeated Character Pattern (A, BB, CCC)");
            System.out.println("4. Q36: Hollow Square Pattern");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();

            // If the user selects a valid pattern, prompt for rows
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter the size / number of rows: ");
                int rows = sc.nextInt();
                System.out.println("\n--- Output ---");

                switch (choice) {
                    case 1:
                        printReverseStarPattern(rows);
                        break;
                    case 2:
                        printReverseNumberTriangle(rows);
                        break;
                    case 3:
                        printRepeatedCharPattern(rows);
                        break;
                    case 4:
                        printHollowSquarePattern(rows);
                        break;
                }
                System.out.println("--------------");
            } else if (choice == 5) {
                System.out.println("Exiting program. Keep up the great momentum!");
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
