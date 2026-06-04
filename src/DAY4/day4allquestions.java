package DAY4;


import java.util.Scanner;

public class day4allquestions {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("     DAY 4 PRACTICE PROBLEMS     ");
            System.out.println("=================================");
            System.out.println("1. Q13: Generate Fibonacci Series");
            System.out.println("2. Q14: Find nth Fibonacci Term");
            System.out.println("3. Q15: Check Armstrong Number");
            System.out.println("4. Q16: Print Armstrong Numbers in a Range");
            System.out.println("0. Exit");
            System.out.print("Select a problem (0-4): ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting Day 4 practice. Happy coding!");
                break;
            }

            switch (choice) {
                case 1 -> runFibonacciSeries();
                case 2 -> runNthFibonacci();
                case 3 -> runCheckArmstrong();
                case 4 -> runArmstrongRange();
                default -> System.out.println("Invalid choice! Please select between 0 and 4.");
            }
        }
    }

    // ==========================================
    // CONTROLLER METHODS FOR MENU
    // ==========================================

    private static void runFibonacciSeries() {
        System.out.print("Enter the number of terms to generate: ");
        int terms = scanner.nextInt();
        if (terms <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            generateFibonacci(terms);
        }
    }

    private static void runNthFibonacci() {
        System.out.print("Enter the position (n) of the Fibonacci term: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Invalid position! Position must be greater than 0.");
        } else {
            System.out.println("The " + n + "th Fibonacci term is: " + getNthFibonacci(n));
        }
    }

    private static void runCheckArmstrong() {
        System.out.print("Enter an integer to check: ");
        int number = scanner.nextInt();
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }

    private static void runArmstrongRange() {
        System.out.print("Enter lower limit (start): ");
        int start = scanner.nextInt();
        System.out.print("Enter upper limit (end): ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.println("Invalid range! Start limit cannot be greater than end limit.");
        } else {
            printArmstrongInRange(start, end);
        }
    }

    // ==========================================
    // LOGICAL FUNCTIONS (CORE ALGORITHMS)
    // ==========================================

    /**
     * Q13: Prints Fibonacci series up to n terms.
     */
    public static void generateFibonacci(int n) {
        long t1 = 0, t2 = 1, nextTerm;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(t1 + " ");
            nextTerm = t1 + t2;
            t1 = t2;
            t2 = nextTerm;
        }
        System.out.println();
    }

    /**
     * Q14: Returns the specific value at the nth position of the Fibonacci sequence.
     */
    public static long getNthFibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        long t1 = 0, t2 = 1, nextTerm = 0;
        for (int i = 3; i <= n; i++) {
            nextTerm = t1 + t2;
            t1 = t2;
            t2 = nextTerm;
        }
        return t2;
    }

    /**
     * Helper Function: Counts the number of digits in an integer.
     */
    public static int countDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        // Handle negative numbers gracefully by using absolute value
        num = Math.abs(num);
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    /**
     * Q15: Validates whether a given integer is an Armstrong number.
     */
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int digits = countDigits(num);
        int sum = 0;

        while (num != 0) {
            int remainder = num % 10;
            sum += Math.pow(remainder, digits);
            num /= 10;
        }
        return (sum == originalNum);
    }

    /**
     * Q16: Loops through a range and prints all valid Armstrong numbers.
     */
    public static void printArmstrongInRange(int start, int end) {
        System.out.print("Armstrong numbers between " + start + " and " + end + " are: ");
        boolean found = false;
        for (int i = start; i <= end; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None found.");
        }
        System.out.println();
    }
}


