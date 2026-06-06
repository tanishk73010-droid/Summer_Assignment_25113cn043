package DAY6;

import java.util.Scanner;

public class Dat6Practice {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("     DAY 6 PRACTICE PROBLEMS     ");
            System.out.println("=================================");
            System.out.println("1. Q21: Convert Decimal to Binary");
            System.out.println("2. Q22: Convert Binary to Decimal");
            System.out.println("3. Q23: Count Set Bits in a Number");
            System.out.println("4. Q24: Find x^n without pow()");
            System.out.println("0. Exit");
            System.out.print("Select a problem (0-4): ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting Day 6 practice. Happy coding!");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter decimal number: ");
                    int decimal = scanner.nextInt();
                    System.out.println("Binary: " + decimalToBinary(decimal));
                }
                case 2 -> {
                    System.out.print("Enter binary string: ");
                    String binary = scanner.next();
                    try {
                        System.out.println("Decimal: " + binaryToDecimal(binary));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Enter number: ");
                    int num = scanner.nextInt();
                    System.out.println("Set bits count: " + countSetBits(num));
                }
                case 4 -> {
                    System.out.print("Enter base (x): ");
                    double x = scanner.nextDouble();
                    System.out.print("Enter exponent (n): ");
                    int n = scanner.nextInt();
                    System.out.println(x + "^" + n + " = " + power(x, n));
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        StringBuilder binary = new StringBuilder();
        boolean isNegative = decimal < 0;
        int num = Math.abs(decimal);

        while (num > 0) {
            binary.append(num % 2);
            num /= 2;
        }
        if (isNegative) {
            binary.append("-");
        }
        return binary.reverse().toString();
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, power);
            } else if (bit != '0') {
                throw new IllegalArgumentException("Invalid binary format!");
            }
            power++;
        }
        return decimal;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    public static double power(double x, int n) {
        double result = 1.0;
        long absN = Math.abs((long) n);

        while (absN > 0) {
            if ((absN & 1) == 1) {
                result *= x;
            }
            x *= x;
            absN >>= 1;
        }

        return n < 0 ? 1.0 / result : result;
    }
}
