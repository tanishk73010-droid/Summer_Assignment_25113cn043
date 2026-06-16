package DAY16;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Day16Programs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 16: Array Operations Menu ---");
            System.out.println("1. Q61: Find missing number in array");
            System.out.println("2. Q62: Find maximum frequency element");
            System.out.println("3. Q63: Find pair with given sum");
            System.out.println("4. Q64: Remove duplicates from array");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runMissingNumber(scanner);
                    break;
                case 2:
                    runMaxFrequency(scanner);
                    break;
                case 3:
                    runPairWithSum(scanner);
                    break;
                case 4:
                    runRemoveDuplicates(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Day 16 programs. Keep up the great progress!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Q61: Find missing number in array (Assumes numbers from 1 to n)
    private static void runMissingNumber(Scanner scanner) {
        System.out.print("\nEnter the total expected count of elements (N, including the missing one): ");
        int n = scanner.nextInt();
        int[] arr = new int[n - 1];

        System.out.println("Enter " + (n - 1) + " elements (ranging from 1 to " + n + " with one missing):");
        int actualSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = scanner.nextInt();
            actualSum += arr[i];
        }

        // Mathematical formula for sum of 1 to N numbers
        int expectedSum = n * (n + 1) / 2;
        int missingNumber = expectedSum - actualSum;

        System.out.println("The missing number is: " + missingNumber);
    }

    // Q62: Find maximum frequency element
    private static void runMaxFrequency(Scanner scanner) {
        System.out.print("\nEnter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Using a HashMap to track frequencies efficiently
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxElement = arr[0];
        int maxCount = 0;

        for (var entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        System.out.println("Element with maximum frequency: " + maxElement + " (Appears " + maxCount + " times)");
    }

    // Q63: Find pair with given sum
    private static void runPairWithSum(Scanner scanner) {
        System.out.print("\nEnter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int targetSum = scanner.nextInt();

        // Using a HashSet for an efficient O(n) lookup solution
        HashSet<Integer> seenNumbers = new HashSet<>();
        boolean pairFound = false;

        System.out.println("Pairs with sum " + targetSum + ":");
        for (int num : arr) {
            int complement = targetSum - num;
            if (seenNumbers.contains(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
                pairFound = true;
            }
            seenNumbers.add(num);
        }

        if (!pairFound) {
            System.out.println("No pairs found with the given sum.");
        }
    }

    // Q64: Remove duplicates from array
    private static void runRemoveDuplicates(Scanner scanner) {
        System.out.print("\nEnter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Using a LinkedHashSet to preserve insertion order while removing duplicates
        HashSet<Integer> uniqueSet = new HashSet<>();
        int index = 0;

        // Modifying the array in-place or dynamically filtering
        for (int num : arr) {
            if (!uniqueSet.contains(num)) {
                uniqueSet.add(num);
                arr[index++] = num; // compacting the array
            }
        }

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
