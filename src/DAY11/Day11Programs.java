package DAY11;

import java.util.Scanner;

public class Day11Programs {

    // Q41: Function to find sum of two numbers [cite: 23]
    public static int findSum(int num1, int num2) {
        return num1 + num2;
    }

    // Q42: Function to find maximum of two numbers [cite: 23]
    public static int findMaximum(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    // Q43: Function to check if a number is prime [cite: 23]
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Q44: Function to find factorial of a number [cite: 23]
    public static long findFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 11 C Programming Practice Sheet (Java Version) ---"); [cite: 1, 22]
            System.out.println("1. Q41: Find Sum of Two Numbers"); [cite: 23]
            System.out.println("2. Q42: Find Maximum of Two Numbers"); [cite: 23]
            System.out.println("3. Q43: Check Prime Number"); [cite: 23]
            System.out.println("4. Q44: Find Factorial of a Number"); [cite: 23]
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int b1 = scanner.nextInt();
                    System.out.println("Result: The sum is " + findSum(a1, b1)); [cite: 23]
                    break;

                case 2:
                    System.out.print("Enter first number: ");
                    int a2 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int b2 = scanner.nextInt();
                    System.out.println("Result: The maximum number is " + findMaximum(a2, b2)); [cite: 23]
                    break;

                case 3:
                    System.out.print("Enter a number to check prime: ");
                    int primeNum = scanner.nextInt();
                    if (isPrime(primeNum)) { [cite: 23]
                        System.out.println("Result: " + primeNum + " is a prime number."); [cite: 23]
                    } else {
                        System.out.println("Result: " + primeNum + " is not a prime number."); [cite: 23]
                    }
                    break;

                case 4:
                    System.out.print("Enter a number for factorial: ");
                    int factNum = scanner.nextInt();
                    if (factNum < 0) {
                        System.out.println("Result: Factorial is not defined for negative numbers.");
                    } else {
                        System.out.println("Result: Factorial of " + factNum + " is " + findFactorial(factNum)); [cite: 23]
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program. Happy coding!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}