package DAY30;

import java.util.ArrayList;
import java.util.Scanner;

public class Day30CombinedSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("    DAY 30: INTEGRATED SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Student Record System (Q117)");
            System.out.println("2. Mini Library System (Q118)");
            System.out.println("3. Mini Employee Management (Q119)");
            System.out.println("4. Complete Mini Project: Inventory (Q120)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    runStudentRecordSystem();
                    break;
                case 2:
                    runMiniLibrarySystem();
                    break;
                case 3:
                    runEmployeeSystem();
                    break;
                case 4:
                    runMiniProject();
                    break;
                case 5:
                    System.out.println("Congratulations on completing the 30-Day Challenge! 🎉");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // =========================================================================
    // 1. Q117: STUDENT RECORD SYSTEM (Arrays & Strings)
    // =========================================================================
    static class Student {
        String name;
        int[] grades;

        Student(String name, int[] grades) {
            this.name = name;
            this.grades = grades;
        }

        double getAverage() {
            int sum = 0;
            for (int g : grades) sum += g;
            return grades.length > 0 ? (double) sum / grades.length : 0;
        }
    }

    private static final ArrayList<Student> students = new ArrayList<>();

    private static void runStudentRecordSystem() {
        while (true) {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student with Grades");
            System.out.println("2. Display Performance Report");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 3) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number of subjects: ");
                    int numSubs = scanner.nextInt();
                    int[] grades = new int[numSubs];
                    for (int i = 0; i < numSubs; i++) {
                        System.out.print("Enter grade for Subject " + (i + 1) + ": ");
                        grades[i] = scanner.nextInt();
                    }
                    students.add(new Student(name, grades));
                    System.out.println("Student record saved.");
                    break;
                case 2:
                    if (students.isEmpty()) System.out.println("No student records available.");
                    for (Student s : students) {
                        System.out.printf("Student: %-15s | Average Grade: %.2f\n", s.name, s.getAverage());
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 2. Q118: MINI LIBRARY SYSTEM
    // =========================================================================
    static class MiniBook {
        String title, author;
        MiniBook(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    private static final ArrayList<MiniBook> miniLibrary = new ArrayList<>();

    private static void runMiniLibrarySystem() {
        while (true) {
            System.out.println("\n--- Mini Library System ---");
            System.out.println("1. Catalog New Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 3) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    miniLibrary.add(new MiniBook(title, author));
                    System.out.println("Book cataloged successfully.");
                    break;
                case 2:
                    System.out.print("Enter title keyword to search: ");
                    String searchKey = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    for (MiniBook b : miniLibrary) {
                        if (b.title.toLowerCase().contains(searchKey)) {
                            System.out.println("Found -> Title: " + b.title + " | Author: " + b.author);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No matching books found.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 3. Q119: MINI EMPLOYEE MANAGEMENT SYSTEM
    // =========================================================================
    static class Employee {
        int id;
        String name, department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
    }

    private static final ArrayList<Employee> employees = new ArrayList<>();

    private static void runEmployeeSystem() {
        while (true) {
            System.out.println("\n--- Mini Employee Management System ---");
            System.out.println("1. Register Employee");
            System.out.println("2. List All Employees");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 3) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String empName = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    employees.add(new Employee(id, empName, dept));
                    System.out.println("Employee registered successfully.");
                    break;
                case 2:
                    if (employees.isEmpty()) System.out.println("No employees found.");
                    for (Employee e : employees) {
                        System.out.println("ID: " + e.id + " | Name: " + e.name + " | Dept: " + e.department);
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 4. Q120: COMPLETE MINI PROJECT (Arrays, Strings, and Functions)
    // =========================================================================
    // This functions as an automated Product Billing module to tie it all together.
    private static String[] productNames = new String[5];
    private static double[] productPrices = new double[5];
    private static int productCount = 0;

    private static void runMiniProject() {
        while (true) {
            System.out.println("\n--- Complete Mini Project: Store Billing System ---");
            System.out.println("1. Setup Store Catalog (Max 5 products)");
            System.out.println("2. Generate Customer Bill");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 3) break;
            switch (ch) {
                case 1:
                    System.out.print("How many products do you want to add? (Max 5): ");
                    productCount = scanner.nextInt();
                    scanner.nextLine();
                    if (productCount > 5) productCount = 5;

                    for (int i = 0; i < productCount; i++) {
                        System.out.print("Enter product " + (i + 1) + " name: ");
                        productNames[i] = scanner.nextLine();
                        System.out.print("Enter product " + (i + 1) + " price: ");
                        productPrices[i] = scanner.nextDouble();
                        scanner.nextLine();
                    }
                    System.out.println("Catalog built successfully.");
                    break;
                case 2:
                    if (productCount == 0) {
                        System.out.println("Please configure store catalog first.");
                        break;
                    }
                    System.out.println("\n--- Available Catalog ---");
                    for (int i = 0; i < productCount; i++) {
                        System.out.printf("%d. %-15s - $%.2f\n", (i + 1), productNames[i], productPrices[i]);
                    }
                    System.out.print("Select product item number to purchase: ");
                    int selection = scanner.nextInt() - 1;
                    if (selection >= 0 && selection < productCount) {
                        System.out.print("Enter Quantity: ");
                        int qty = scanner.nextInt();
                        double netTotal = productPrices[selection] * qty;
                        System.out.println("\n------------------------------");
                        System.out.println("         RECEIPT              ");
                        System.out.println("------------------------------");
                        System.out.println("Product: " + productNames[selection].toUpperCase());
                        System.out.println("Quantity: " + qty);
                        System.out.printf("Total Payable Amount: $%.2f\n", netTotal);
                        System.out.println("------------------------------");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
