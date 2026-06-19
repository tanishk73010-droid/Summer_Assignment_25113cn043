package DAY19;

import java.util.Scanner;

public class Day19programs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in);

        System.out.println("--- Day 19: Matrix Operations Program ---");

        // Input dimensions for the primary matrix
        System.out.print("Enter the number of rows for the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrix: ");
        int cols = scanner.nextInt();

        int[][] matrixA = new int[rows][cols];
        System.out.println("Enter elements for Matrix A:");
        readMatrix(matrixA, scanner);

        while (true) {
            System.out.println("\n--- Choose a Day 19 Program to Execute ---");
            System.out.println("1. Q73: Add Matrices");
            System.out.println("2. Q74: Subtract Matrices");
            System.out.println("3. Q75: Transpose Matrix");
            System.out.println("4. Q76: Find Diagonal Sum");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Q73: Add matrices
                    System.out.println("\n--- Q73: Matrix Addition ---");
                    int[][] matrixBForAdd = new int[rows][cols];
                    System.out.println("Enter elements for Matrix B (must be same size as Matrix A):");
                    readMatrix(matrixBForAdd, scanner);
                    addMatrices(matrixA, matrixBForAdd);
                    break;

                case 2:
                    // Q74: Subtract matrices
                    System.out.println("\n--- Q74: Matrix Subtraction ---");
                    int[][] matrixBForSub = new int[rows][cols];
                    System.out.println("Enter elements for Matrix B (must be same size as Matrix A):");
                    readMatrix(matrixBForSub, scanner);
                    subtractMatrices(matrixA, matrixBForSub);
                    break;

                case 3:
                    // Q75: Transpose matrix
                    System.out.println("\n--- Q75: Matrix Transpose ---");
                    transposeMatrix(matrixA);
                    break;

                case 4:
                    // Q76: Find diagonal sum
                    System.out.println("\n--- Q76: Diagonal Sum ---");
                    findDiagonalSum(matrixA);
                    break;

                case 5:
                    System.out.println("Exiting the program. Happy Coding!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

    // Helper method to input matrix data
    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Helper method to display a matrix
    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Q73: Write a program to Add matrices
    private static void addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Result of Matrix Addition (A + B):");
        displayMatrix(result);
    }

    // Q74: Write a program to Subtract matrices
    private static void subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        System.out.println("Result of Matrix Subtraction (A - B):");
        displayMatrix(result);
    }

    // Q75: Write a program to Transpose matrix
    private static void transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows]; // Rows and columns swap

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        System.out.println("Original Matrix A:");
        displayMatrix(matrix);
        System.out.println("Transposed Matrix:");
        displayMatrix(transposed);
    }

    // Q76: Write a program to Find diagonal sum
    private static void findDiagonalSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Primary diagonal condition (i == j)
                if (i == j) {
                    primaryDiagonalSum += matrix[i][j];
                }
                // Secondary diagonal condition (i + j == order - 1)
                if ((i + j) == (rows - 1)) {
                    secondaryDiagonalSum += matrix[i][j];
                }
            }
        }

        System.out.println("Matrix Checked:");
        displayMatrix(matrix);
        System.out.println("Sum of Primary Diagonal Elements: " + primaryDiagonalSum);

        if (rows == cols) {
            System.out.println("Sum of Secondary Diagonal Elements: " + secondaryDiagonalSum);
        } else {
            System.out.println("(Secondary diagonal sum is only fully standardized for square matrices)");
        }
    }
}
