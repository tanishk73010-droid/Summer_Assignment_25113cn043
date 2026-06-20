package DAY20;

import java.util.Scanner;

public class Day20program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Day 20 Matrix Operations Menu ---");
            System.out.println("1. Multiply Two Matrices (Q77)");
            System.out.println("2. Check Symmetric Matrix (Q78)");
            System.out.println("3. Find Row-wise Sum (Q79)");
            System.out.println("4. Find Column-wise Sum (Q80)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleMatrixMultiplication(scanner);
                    break;
                case 2:
                    handleSymmetricCheck(scanner);
                    break;
                case 3:
                    handleRowWiseSum(scanner);
                    break;
                case 4:
                    handleColumnWiseSum(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program. Happy coding!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Q77: Multiply Matrices
    private static void handleMatrixMultiplication(Scanner scanner) {
        System.out.print("Enter rows and columns for Matrix A: ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        System.out.print("Enter rows and columns for Matrix B: ");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        if (c1 != r2) {
            System.out.println("Error: Multiplication not possible! Columns of A must equal rows of B.");
            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];
        int[][] product = new int[r1][c2];

        System.out.println("Enter elements for Matrix A:");
        fillMatrix(scanner, A);

        System.out.println("Enter elements for Matrix B:");
        fillMatrix(scanner, B);

        // Multiplication logic
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Product Matrix:");
        printMatrix(product);
    }

    // Q78: Check Symmetric Matrix
    private static void handleSymmetricCheck(Scanner scanner) {
        System.out.print("Enter size of square matrix (N x N): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter matrix elements:");
        fillMatrix(scanner, matrix);

        boolean isSymmetric = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
        }

        if (isSymmetric) {
            System.out.println("The matrix is symmetric.");
        } else {
            System.out.println("The matrix is NOT symmetric.");
        }
    }

    // Q79: Find Row-wise Sum
    private static void handleRowWiseSum(Scanner scanner) {
        System.out.print("Enter rows and columns of the matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        fillMatrix(scanner, matrix);

        System.out.println("Row-wise Sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of Row " + (i + 1) + " = " + rowSum);
        }
    }

    // Q80: Find Column-wise Sum
    private static void handleColumnWiseSum(Scanner scanner) {
        System.out.print("Enter rows and columns of the matrix: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        fillMatrix(scanner, matrix);

        System.out.println("Column-wise Sums:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of Column " + (j + 1) + " = " + colSum);
        }
    }

    // Helper method to scan matrix inputs
    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Helper method to print matrices
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}