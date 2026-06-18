package DAY18;

import java.util.Scanner;
import java.util.Arrays;

public class Day18Programs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 18: Searching & Sorting Menu ---");
            System.out.println("1. Q69: Bubble Sort (Ascending)");
            System.out.println("2. Q70: Selection Sort (Ascending)");
            System.out.println("3. Q71: Binary Search");
            System.out.println("4. Q72: Sort Array in Descending Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runBubbleSort(scanner);
                    break;
                case 2:
                    runSelectionSort(scanner);
                    break;
                case 3:
                    runBinarySearch(scanner);
                    break;
                case 4:
                    runDescendingSort(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Day 18 programs. Fantastic work today!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Helper method to read array input from user
    private static int[] inputArray(Scanner scanner) {
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // Q69: Bubble Sort
    private static void runBubbleSort(Scanner scanner) {
        System.out.println("\n--- Q69: Bubble Sort ---");
        int[] arr = inputArray(scanner);

        int n = arr.length;
        // Repeatedly swap adjacent elements if they are in the wrong order
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization to stop early if already sorted
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(arr));
    }

    // Q70: Selection Sort
    private static void runSelectionSort(Scanner scanner) {
        System.out.println("\n--- Q70: Selection Sort ---");
        int[] arr = inputArray(scanner);

        int n = arr.length;
        // Move the boundary of the unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted Array (Selection Sort): " + Arrays.toString(arr));
    }

    // Q71: Binary Search
    private static void runBinarySearch(Scanner scanner) {
        System.out.println("\n--- Q71: Binary Search ---");
        System.out.println("Note: Binary Search strictly requires a SORTED array.");
        int[] arr = inputArray(scanner);

        // Sorting the array first to guarantee Binary Search works correctly
        Arrays.sort(arr);
        System.out.println("Array sorted for binary search: " + Arrays.toString(arr));

        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();

        int low = 0;
        int high = arr.length - 1;
        int resultIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents potential integer overflow

            if (arr[mid] == target) {
                resultIndex = mid;
                break; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search the right half
            } else {
                high = mid - 1; // Search the left half
            }
        }

        if (resultIndex != -1) {
            System.out.println("Element found at index (in sorted array): " + resultIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    // Q72: Sort Array in Descending Order
    private static void runDescendingSort(Scanner scanner) {
        System.out.println("\n--- Q72: Sort Array in Descending Order ---");
        int[] arr = inputArray(scanner);

        int n = arr.length;
        // Using an adjusted Selection Sort to sort downwards
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            // Find the maximum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the first element
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Sorted Array (Descending Order): " + Arrays.toString(arr));
    }
}
