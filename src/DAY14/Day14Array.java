package DAY14;

import java.util.Scanner;

public class Day14Array {

    // Q53: Linear search
    public static void linearSearch(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found.");
        }
    }

    // Q54: Frequency of elements
    public static void findFrequency(int[] arr) {
        // Creating a clone so we don't modify the original array
        int[] tempArr = arr.clone();
        System.out.println("Element Frequencies:");

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == Integer.MIN_VALUE) {
                continue; // Skip already counted elements
            }
            int count = 1;
            for (int j = i + 1; j < tempArr.length; j++) {
                if (tempArr[i] == tempArr[j]) {
                    count++;
                    tempArr[j] = Integer.MIN_VALUE; // Mark as visited
                }
            }
            System.out.println(tempArr[i] + " occurs " + count + " times");
        }
    }

    // Q55: Second largest element
    public static void secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("Second largest element is: " + second);
        }
    }

    // Q56: Find duplicates in array
    public static void findDuplicates(int[] arr) {
        System.out.print("Duplicate elements: ");
        boolean hasDuplicates = false;

        // Simple track array to avoid printing the same duplicate multiple times
        int[] tempArr = arr.clone();

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == Integer.MIN_VALUE) continue;

            boolean isDuplicate = false;
            for (int j = i + 1; j < tempArr.length; j++) {
                if (tempArr[i] == tempArr[j]) {
                    isDuplicate = true;
                    tempArr[j] = Integer.MIN_VALUE; // Mark to avoid re-checking
                }
            }
            if (isDuplicate) {
                System.out.print(tempArr[i] + " ");
                hasDuplicates = true;
            }
        }
        if (!hasDuplicates) System.out.print("None");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n--- Day 14 Program Menu ---");
        System.out.println("1: Linear Search (Q53)");
        System.out.println("2: Frequency of Elements (Q54)");
        System.out.println("3: Second Largest Element (Q55)");
        System.out.println("4: Find Duplicates (Q56)");
        System.out.print("Choose an option (1-4): ");
        int choice = sc.nextInt();

        System.out.println();
        switch (choice) {
            case 1: linearSearch(arr); break;
            case 2: findFrequency(arr); break;
            case 3: secondLargest(arr); break;
            case 4: findDuplicates(arr); break;
            default: System.out.println("Invalid choice!");
        }

        sc.close();
    }
}