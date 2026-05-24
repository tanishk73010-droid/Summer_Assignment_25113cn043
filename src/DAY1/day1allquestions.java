package DAY1;

import java.util.Scanner;

public class day1allquestions{

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void printTable(int number) {
        System.out.println("\n--- Multiplication Table for " + number + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static long findFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("      DAY 1 PROGRAM MENU         ");
            System.out.println("==================================");
            System.out.println("1. Q1: Sum of first N natural numbers");
            System.out.println("2. Q2: Multiplication table");
            System.out.println("3. Q3: Factorial of a number");
            System.out.println("4. Q4: Count digits in a number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter N: ");
                    int n = scanner.nextInt();
                    if (n < 1) {
                        System.out.println("Please enter a positive integer.");
                    } else {
                        System.out.println("Sum of first " + n + " natural numbers: " + calculateSum(n));
                    }
                    break;

                case 2:
                    System.out.print("Enter number: ");
                    int tableNum = scanner.nextInt();
                    printTable(tableNum);
                    break;

                case 3:
                    System.out.print("Enter a non-negative integer: ");
                    int factNum = scanner.nextInt();
                    if (factNum < 0) {
                        System.out.println("Factorial is not defined for negative numbers.");
                    } else {
                        System.out.println("Factorial of " + factNum + " is: " + findFactorial(factNum));
                    }
                    break;

                case 4:
                    System.out.print("Enter any integer: ");
                    int digitNum = scanner.nextInt();
                    System.out.println("Total digits: " + countDigits(digitNum));
                    break;

                case 5:
                    System.out.println("Exiting... Have a great day!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}