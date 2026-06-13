package DAY13
import java.util.Scanner;

public class Day13Programing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Initializing a default array for ease of testing,
        // but Option 1 allows the user to input a custom one.
        int[] array = {12, 5, 18, 23, -4, 0, 7, 12};

        do {
            System.out.println("\n=================================");
            System.out.println("     DAY 13 JAVA PROGRAM MENU    ");
            System.out.println("=================================");
            System.out.println("Current Array: " + arrayToString(array));
            System.out.println("---------------------------------");
            System.out.println("1. Input and Display New Array (Q49)");
            System.out.println("2. Find Sum and Average of Array (Q50)");
            System.out.println("3. Find Largest and Smallest Element (Q51)");
            System.out.println("4. Count Even and Odd Elements (Q52)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid choice.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Q49: Input and Display Array ---");
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    if (size <= 0) {
                        System.out.println("Invalid size! Reverting to previous array.");
                    } else {
                        array = new int[size];
                        System.out.println("Enter " + size + " elements:");
                        for (int i = 0; i < size; i++) {
                            System.out.print("Element [" + i + "]: ");
                            array[i] = scanner.nextInt();
                        }
                        System.out.print("The newly entered array is: ");
                        displayArray(array);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Q50: Sum and Average ---");
                    findSumAndAverage(array);
                    break;

                case 3:
                    System.out.println("\n--- Q51: Largest and Smallest ---");
                    findMinAndMax(array);
                    break;

                case 4:
                    System.out.println("\n--- Q52: Even and Odd Count ---");
                    countEvenOdd(array);
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
     * Q49: Function to display array elements
     */
    public static void displayArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Q50: Function to find the sum and average of an array
     */
    public static void findSumAndAverage(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        // Casting sum to double to get a precise average value
        double average = (double) sum / arr.length;

        System.out.println("Sum of elements: " + sum);
        System.out.printf("Average of elements: %.2f\n", average);
    }

    /**
     * Q51: Function to find the largest and smallest elements
     */
    public static void findMinAndMax(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Smallest Element: " + min);
        System.out.println("Largest Element: " + max);
    }

    /**
     * Q52: Function to count even and odd elements
     */
    public static void countEvenOdd(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Total Even Elements: " + evenCount);
        System.out.println("Total Odd Elements: " + oddCount);
    }

    /**
     * Helper method to seamlessly preview the state of the array in the menu header
     */
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
