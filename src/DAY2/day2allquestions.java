package DAY2;

import java.util.Scanner;

public class day2allquestions{

    public static int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        return reverse;
    }

    public static int productOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
        int product = 1;
        number = Math.abs(number);
        while (number > 0) {
            product *= number % 10;
            number = number / 10;
        }
        return product;
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        return number == reverseNumber(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("      DAY 2 PROGRAM MENU         ");
            System.out.println("==================================");
            System.out.println("1. Q5: Sum of digits of a number");
            System.out.println("2. Q6: Reverse a number");
            System.out.println("3. Q7: Product of digits");
            System.out.println("4. Q8: Check if number is palindrome");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer: ");
                    int num5 = scanner.nextInt();
                    System.out.println("Sum of digits: " + sumOfDigits(num5));
                    break;

                case 2:
                    System.out.print("Enter an integer: ");
                    int num6 = scanner.nextInt();
                    System.out.println("Reversed number: " + reverseNumber(num6));
                    break;

                case 3:
                    System.out.print("Enter an integer: ");
                    int num7 = scanner.nextInt();
                    System.out.println("Product of digits: " + productOfDigits(num7));
                    break;

                case 4:
                    System.out.print("Enter an integer: ");
                    int num8 = scanner.nextInt();
                    if (isPalindrome(num8)) {
                        System.out.println(num8 + " is a palindrome.");
                    } else {
                        System.out.println(num8 + " is not a palindrome.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Day 2 Menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
