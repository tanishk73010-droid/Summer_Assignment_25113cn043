package DAY12;

import java.util.Scanner;

public class Day12Programs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, num;

        do {
            System.out.println("\n=================================");
            System.out.println("     DAY 12 JAVA PROGRAM MENU    ");
            System.out.println("=================================");
            System.out.println("1. Check Palindrome Number (Q45)");
            System.out.println("2. Check Armstrong Number (Q46)");
            System.out.println("3. Generate Fibonacci Series (Q47)");
            System.out.println("4. Check Perfect Number (Q48)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Handle non-integer inputs gracefully
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Q45: Palindrome Check ---");
                    System.out.print("Enter an integer: ");
                    num = scanner.nextInt();
                    if (isPalindrome(num)) {
                        System.out.println(num + " is a Palindrome number.");
                    } else {
                        System.out.println(num + " is NOT a Palindrome number.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Q46: Armstrong Check ---");
                    System.out.print("Enter an integer: ");
                    num = scanner.nextInt();
                    if (isArmstrong(num)) {
                        System.out.println(num + " is an Armstrong number.");
                    } else {
                        System.out.println(num + " is NOT an Armstrong number.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Q47: Fibonacci Generation ---");
                    System.out.print("Enter the number of terms to print: ");
                    num = scanner.nextInt();
                    if (num <= 0) {
                        System.out.println("Please enter a positive integer.");
                    } else {
                        printFibonacci(num);
                    }
                    break;

                case 4:
                    System.out.println("\n--- Q48: Perfect Number Check ---");
                    System.out.print("Enter an integer: ");
                    num = scanner.nextInt();
                    if (isPerfect(num)) {
                        System.out.println(num + " is a Perfect number.");
                    } else {
                        System.out.println(num + " is NOT a Perfect number.");
                    }
                    break;

                case 5:
                    System.out.println("\nExiting the program. Happy Coding!");
                    break;

                default:
                    System.out.println("\nInvalid Choice! Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // ==========================================
    // METHOD DEFINITIONS
    // ==========================================

    /**
     * Q45: Check if a number is a Palindrome [cite: 25]
     */
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int remainder = num % 10;
            reversed = (reversed * 10) + remainder;
            num /= 10;
        }

        return original == reversed;
    }

    /**
     * Q46: Check if a number is an Armstrong number [cite: 25]
     * Optimized without using Math.pow() to keep integer math clean.
     */
    public static boolean isArmstrong(int num) {
        int original = num;
        int temp = num;
        int digits = 0;
        int sum = 0;

        // Count total number of digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;
        // Calculate Armstrong sum
        while (temp > 0) {
            int remainder = temp % 10;

            // Manual exponentiation mechanism
            int powerValue = 1;
            for (int i = 0; i < digits; i++) {
                powerValue *= remainder;
            }

            sum += powerValue;
            temp /= 10;
        }

        return original == sum;
    }

    /**
     * Q47: Print the Fibonacci series up to N terms [cite: 25]
     */
    public static void printFibonacci(int terms) {
        int t1 = 0, t2 = 1;

        System.out.print("Fibonacci Series up to " + terms + " terms: ");

        for (int i = 1; i <= terms; ++i) {
            System.out.print(t1);
            if (i < terms) {
                System.out.print(", ");
            }
            int nextTerm = t1 + t2;
            t1 = t2;
            t2 = nextTerm;
        }
        System.out.println();
    }

    /**
     * Q48: Check if a number is a Perfect number [cite: 25]
     */
    public static boolean isPerfect(int num) {
        if (num <= 0) return false;

        int sum = 0;
        // Loop runs up to num/2 for efficiency
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}
