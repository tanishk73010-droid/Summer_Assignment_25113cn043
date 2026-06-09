package DAY8;


import java.util.Scanner;

public class Day8allques {

    // Q29: Function to print the half pyramid
    public static void printHalfPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q30: Function to print the number triangle
    public static void printNumberTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Q31: Function to print the character triangle
    public static void printCharTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            char ch = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    // Q32: Function to print the repeated-number pattern
    public static void printRepeatedNumber(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display Menu
            System.out.println("\n--- Day 8 Pattern Printing Menu ---");
            System.out.println("1. Q29: Half Pyramid Pattern (*)");
            System.out.println("2. Q30: Number Triangle (1, 12, 123...)");
            System.out.println("3. Q31: Character Triangle (A, AB, ABC...)");
            System.out.println("4. Q32: Repeated Number Pattern (1, 22, 333...)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();

            // If the user wants to print a pattern, ask for rows
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter the number of rows: ");
                int rows = sc.nextInt();
                System.out.println("\n--- Output ---");

                switch (choice) {
                    case 1:
                        printHalfPyramid(rows);
                        break;
                    case 2:
                        printNumberTriangle(rows);
                        break;
                    case 3:
                        printCharTriangle(rows);
                        break;
                    case 4:
                        printRepeatedNumber(rows);
                        break;
                }
                System.out.println("--------------");
            } else if (choice == 5) {
                System.out.println("Exiting program. Happy coding!");
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}