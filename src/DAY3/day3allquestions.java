package DAY3;

import java.util.Scanner;

public class day3allquestions {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimesInRange(int start, int end) {
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        boolean found = false;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static int findLCM(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("      DAY 3 PROGRAM MENU         ");
            System.out.println("==================================");
            System.out.println("1. Q9: Check if number is prime");
            System.out.println("2. Q10: Print prime numbers in a range");
            System.out.println("3. Q11: Find GCD of two numbers");
            System.out.println("4. Q12: Find LCM of two numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer: ");
                    int num9 = scanner.nextInt();
                    if (isPrime(num9)) {
                        System.out.println(num9 + " is a prime number.");
                    } else {
                        System.out.println(num9 + " is not a prime number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter start of range: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end of range: ");
                    int end = scanner.nextInt();
                    printPrimesInRange(start, end);
                    break;

                case 3:
                    System.out.print("Enter first number: ");
                    int gcdA = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int gcdB = scanner.nextInt();
                    System.out.println("GCD of " + gcdA + " and " + gcdB + " is: " + findGCD(gcdA, gcdB));
                    break;

                case 4:
                    System.out.print("Enter first number: ");
                    int lcmA = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int lcmB = scanner.nextInt();
                    System.out.println("LCM of " + lcmA + " and " + lcmB + " is: " + findLCM(lcmA, lcmB));
                    break;

                case 5:
                    System.out.println("Exiting Day 3 Menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
