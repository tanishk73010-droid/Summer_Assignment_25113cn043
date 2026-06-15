package DAY15;

import java.util.Arrays;
import java.util.Scanner;

public class Day15Arrays {

    // Q57: Reverse array
    public static void reverseArray(int[] arr) {
        int[] temp = arr.clone();
        int start = 0, end = temp.length - 1;
        while (start < end) {
            int t = temp[start];
            temp[start] = temp[end];
            temp[end] = t;
            start++;
            end--;
        }
        System.out.println("Reversed Array: " + Arrays.toString(temp));
    }

    // Q58: Rotate array left by k positions
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[(i + k) % n];
        }
        System.out.println("Left Rotated Array: " + Arrays.toString(temp));
    }

    // Q59: Rotate array right by k positions
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }
        System.out.println("Right Rotated Array: " + Arrays.toString(temp));
    }

    // Q60: Move all zeroes to the end (maintaining order of other elements)
    public static void moveZeroesToEnd(int[] arr) {
        int[] temp = arr.clone();
        int count = 0; // Index tracker for non-zero elements

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                temp[count++] = temp[i];
            }
        }
        // Fill the remaining positions with zeroes
        while (count < temp.length) {
            temp[count++] = 0;
        }
        System.out.println("Array after moving zeroes: " + Arrays.toString(temp));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.class);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n--- Day 15 Program Menu ---");
        System.out.println("1: Reverse Array (Q57)");
        System.out.println("2: Rotate Array Left (Q58)");
        System.out.println("3: Rotate Array Right (Q59)");
        System.out.println("4: Move Zeroes to End (Q60)");
        System.out.print("Choose an option (1-4): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                reverseArray(arr);
                break;
            case 2:
                System.out.print("Enter number of positions to rotate left: ");
                int kLeft = sc.nextInt();
                rotateLeft(arr, kLeft);
                break;
            case 3:
                System.out.print("Enter number of positions to rotate right: ");
                int kRight = sc.nextInt();
                rotateRight(arr, kRight);
                break;
            case 4:
                moveZeroesToEnd(arr);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
