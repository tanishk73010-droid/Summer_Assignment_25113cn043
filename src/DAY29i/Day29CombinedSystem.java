package DAY29i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day29CombinedSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("    DAY 29: INTEGRATED SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Menu-driven Calculator (Q113)");
            System.out.println("2. Menu-driven Array Operations (Q114)");
            System.out.println("3. Menu-driven String Operations (Q115)");
            System.out.println("4. Inventory Management System (Q116)");
            System.out.println("5. Exit");
            System.out.print("Enter your master choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    runCalculator();
                    break;
                case 2:
                    runArrayOperations();
                    break;
                case 3:
                    runStringOperations();
                    break;
                case 4:
                    runInventorySystem();
                    break;
                case 5:
                    System.out.println("Exiting Day 29 System. Keep up the great progress!");
                    return;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

    // =========================================================================
    // 1. Q113: MENU-DRIVEN CALCULATOR
    // =========================================================================
    private static void runCalculator() {
        while (true) {
            System.out.println("\n--- Calculator Submenu ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Return to Master Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            if (ch == 5) break;

            if (ch >= 1 && ch <= 4) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (ch) {
                    case 1: System.out.println("Result: " + (num1 + num2)); break;
                    case 2: System.out.println("Result: " + (num1 - num2)); break;
                    case 3: System.out.println("Result: " + (num1 * num2)); break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Result: " + (num1 / num2));
                        } else {
                            System.out.println("Error: Division by zero is undefined.");
                        }
                        break;
                }
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 2. Q114: MENU-DRIVEN ARRAY OPERATIONS SYSTEM
    // =========================================================================
    private static int[] dynamicArray = new int[0];

    private static void runArrayOperations() {
        while (true) {
            System.out.println("\n--- Array Operations Submenu ---");
            System.out.println("Current Array: " + Arrays.toString(dynamicArray));
            System.out.println("1. Initialize/Reset Array");
            System.out.println("2. Find Maximum Element");
            System.out.println("3. Calculate Sum of Elements");
            System.out.println("4. Return to Master Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            if (ch == 4) break;

            switch (ch) {
                case 1:
                    System.out.print("Enter size of the array: ");
                    int size = scanner.nextInt();
                    dynamicArray = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        dynamicArray[i] = scanner.nextInt();
                    }
                    System.out.println("Array initialized successfully.");
                    break;
                case 2:
                    if (dynamicArray.length == 0) {
                        System.out.println("Array is empty! Please initialize it first.");
                    } else {
                        int max = dynamicArray[0];
                        for (int val : dynamicArray) {
                            if (val > max) max = val;
                        }
                        System.out.println("Maximum element: " + max);
                    }
                    break;
                case 3:
                    int sum = 0;
                    for (int val : dynamicArray) sum += val;
                    System.out.println("Sum of elements: " + sum);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 3. Q115: MENU-DRIVEN STRING OPERATIONS SYSTEM
    // =========================================================================
    private static void runStringOperations() {
        while (true) {
            System.out.println("\n--- String Operations Submenu ---");
            System.out.println("1. Reverse a String");
            System.out.println("2. Check Palindrome");
            System.out.println("3. Count Vowels");
            System.out.println("4. Return to Master Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            if (ch == 4) break;

            if (ch >= 1 && ch <= 3) {
                System.out.print("Enter your target string: ");
                String str = scanner.nextLine();

                switch (ch) {
                    case 1:
                        String reversed = new StringBuilder(str).reverse().toString();
                        System.out.println("Reversed String: " + reversed);
                        break;
                    case 2:
                        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
                        String revStr = new StringBuilder(cleanStr).reverse().toString();
                        if (cleanStr.equals(revStr)) {
                            System.out.println("\"" + str + "\" is a palindrome.");
                        } else {
                            System.out.println("\"" + str + "\" is NOT a palindrome.");
                        }
                        break;
                    case 3:
                        int vowels = 0;
                        for (char c : str.toLowerCase().toCharArray()) {
                            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                                vowels++;
                            }
                        }
                        System.out.println("Number of vowels: " + vowels);
                        break;
                }
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 4. Q116: INVENTORY MANAGEMENT SYSTEM
    // =========================================================================
    static class Item {
        String name;
        int quantity;
        double price;

        Item(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    private static final ArrayList<Item> inventory = new ArrayList<>();

    private static void runInventorySystem() {
        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add New Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Total Inventory Value");
            System.out.println("4. Return to Master Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            if (ch == 4) break;

            switch (ch) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter unit price: ");
                    double price = scanner.nextDouble();

                    inventory.add(new Item(name, qty, price));
                    System.out.println("Item added to inventory successfully!");
                    break;
                case 2:
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.printf("%-15s %-10s %-10s\n", "Item Name", "Quantity", "Price");
                        System.out.println("-------------------------------------");
                        for (Item item : inventory) {
                            System.out.printf("%-15s %-10d $%-10.2f\n", item.name, item.quantity, item.price);
                        }
                    }
                    break;
                case 3:
                    double totalValue = 0;
                    for (Item item : inventory) {
                        totalValue += (item.quantity * item.price);
                    }
                    System.out.printf("Total Financial Value of Inventory: $%.2f\n", totalValue);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
