package DAY5;

import java.util.Scanner;

public class Day5practice {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("     DAY 5 PRACTICE PROBLEMS     ");
            System.out.println("=================================");
            System.out.println("1. Q17: Check Perfect Number");
            System.out.println("2. Q18: Check Strong Number");
            System.out.println("3. Q19: Print Factors of a Number");
            System.out.println("4. Q20: Find Largest Prime Factor");
            System.out.println("0. Exit");
            System.out.print("Select a problem (0-4): ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting Day 5 practice. Happy coding!");
                break;
            }

            System.out.print("Enter number: ");
            int n = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println(n + " is Perfect? " + isPerfect(n));
                case 2 -> System.out.println(n + " is Strong? " + isStrong(n));
                case 3 -> printFactors(n);
                case 4 -> System.out.println("Largest Prime Factor: " + getLargestPrimeFactor(n));
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static boolean isPerfect(int num) {
        if (num <= 1) return false;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    public static long getFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isStrong(int num) {
        int original = num;
        long sum = 0;
        while (num != 0) {
            sum += getFactorial(num % 10);
            num /= 10;
        }
        return sum == original;
    }

    public static void printFactors(int num) {
        System.out.print("Factors of " + num + " are: ");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static long getLargestPrimeFactor(long n) {
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n /= i;
            }
        }
        if (n > 2) {
            maxPrime = n;
        }
        return maxPrime;
    }
}