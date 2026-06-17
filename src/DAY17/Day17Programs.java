package DAY17;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class Day17Programs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 17: Array Set Operations Menu ---");
            System.out.println("1. Q65: Merge two arrays");
            System.out.println("2. Q66: Union of two arrays");
            System.out.println("3. Q67: Intersection of two arrays");
            System.out.println("4. Q68: Find common elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runMergeArrays(scanner);
                    break;
                case 2:
                    runUnionArrays(scanner);
                    break;
                case 3:
                    runIntersectionArrays(scanner);
                    break;
                case 4:
                    runCommonElements(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Day 17 programs. Keep crushing it!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Helper method to read an array from user input
    private static int[] inputArray(Scanner scanner, String arrayName) {
        System.out.print("Enter the number of elements in " + arrayName + ": ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // Q65: Merge arrays
    private static void runMergeArrays(Scanner scanner) {
        System.out.println("\n--- Q65: Merge Arrays ---");
        int[] arr1 = inputArray(scanner, "Array 1");
        int[] arr2 = inputArray(scanner, "Array 2");

        int[] mergedArray = new int[arr1.length + arr2.length];

        // Copy elements from the first array
        for (int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
        }

        // Copy elements from the second array
        for (int i = 0; i < arr2.length; i++) {
            mergedArray[arr1.length + i] = arr2[i];
        }

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }

    // Q66: Union of arrays (Unique elements from both arrays)
    private static void runUnionArrays(Scanner scanner) {
        System.out.println("\n--- Q66: Union of Arrays ---");
        int[] arr1 = inputArray(scanner, "Array 1");
        int[] arr2 = inputArray(scanner, "Array 2");

        // HashSet automatically ignores duplicate values
        HashSet<Integer> unionSet = new HashSet<>();

        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
        }

        System.out.println("Union of Arrays (Unique elements): " + unionSet);
    }

    // Q67: Intersection of arrays (Unique elements present in both)
    private static void runIntersectionArrays(Scanner scanner) {
        System.out.println("\n--- Q67: Intersection of Arrays ---");
        int[] arr1 = inputArray(scanner, "Array 1");
        int[] arr2 = inputArray(scanner, "Array 2");

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        // Add elements of first array to a set
        for (int num : arr1) {
            set1.add(num);
        }

        // If an element of the second array exists in set1, it's an intersection
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        System.out.println("Intersection of Arrays: " + intersectionSet);
    }

    // Q68: Find common elements (Duplicates preserved based on appearance)
    private static void runCommonElements(Scanner scanner) {
        System.out.println("\n--- Q68: Find Common Elements ---");
        int[] arr1 = inputArray(scanner, "Array 1");
        int[] arr2 = inputArray(scanner, "Array 2");

        // A simple O(n*m) demonstration or O(n) using an element tracking list
        ArrayList<Integer> commonElements = new ArrayList<>();

        // Using a copy of array 2 tracking so we don't reuse the same element twice
        boolean[] visited = new boolean[arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !visited[j]) {
                    commonElements.add(arr1[i]);
                    visited[j] = true; // Mark as matched
                    break;
                }
            }
        }

        if (commonElements.isEmpty()) {
            System.out.println("No common elements found.");
        } else {
            System.out.println("Common Elements: " + commonElements);
        }
    }
}