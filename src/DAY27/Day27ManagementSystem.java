package DAY27;

import java.util.ArrayList;
import java.util.Scanner;

public class Day27ManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    // Data lists acting as our in-memory database
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=============================================");
            System.out.println("    DAY 27: INTEGRATED MANAGEMENT SYSTEM     ");
            System.out.println("=============================================");
            System.out.println("1. Student Record Management System (Q105)");
            System.out.println("2. Employee Management System (Q106)");
            System.out.println("3. Salary Management System (Q107)");
            System.out.println("4. Marksheet Generation System (Q108)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    salaryMenu();
                    break;
                case 4:
                    marksheetMenu();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }
        }
    }

    // Helper method to safely catch integer inputs
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return val;
    }

    // Helper method to safely catch double inputs
    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount/marks: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        return val;
    }

    // =========================================================================
    // Q105: STUDENT RECORD MANAGEMENT SYSTEM
    // =========================================================================
    private static void studentMenu() {
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student Record");
            System.out.println("2. View All Student Records");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                int id = getIntInput();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                students.add(new Student(id, name));
                System.out.println("Student record added successfully!");
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No student records found.");
                } else {
                    System.out.println("\n--- Student Records ---");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    // =========================================================================
    // Q106: EMPLOYEE MANAGEMENT SYSTEM
    // =========================================================================
    private static void employeeMenu() {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                int id = getIntInput();
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Designation: ");
                String designation = scanner.nextLine();
                System.out.print("Enter Base Salary: ");
                double baseSalary = getDoubleInput();

                employees.add(new Employee(id, name, designation, baseSalary));
                System.out.println("Employee record added successfully!");
            } else if (choice == 2) {
                if (employees.isEmpty()) {
                    System.out.println("No employees found.");
                } else {
                    System.out.println("\n--- Employee Records ---");
                    for (Employee e : employees) {
                        System.out.println("ID: " + e.id + " | Name: " + e.name + " | Designation: " + e.designation);
                    }
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    // =========================================================================
    // Q107: SALARY MANAGEMENT SYSTEM
    // =========================================================================
    private static void salaryMenu() {
        if (employees.isEmpty()) {
            System.out.println("\n[Note] Please add employees in the Employee Management System first.");
            return;
        }

        while (true) {
            System.out.println("\n--- Salary Management System ---");
            System.out.println("1. Calculate & View Detailed Payroll");
            System.out.println("2. Update Base Salary");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = getIntInput();

            if (choice == 1) {
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.printf("%-5s %-15s %-12s %-10s %-10s %-10s\n", "ID", "Name", "Base Sal", "HRA(15%)", "DA(10%)", "Net Salary");
                System.out.println("-------------------------------------------------------------------------");
                for (Employee e : employees) {
                    double hra = e.baseSalary * 0.15;
                    double da = e.baseSalary * 0.10;
                    double netSalary = e.baseSalary + hra + da;
                    System.out.printf("%-5d %-15s %-12.2f %-10.2f %-10.2f %-10.2f\n", e.id, e.name, e.baseSalary, hra, da, netSalary);
                }
                System.out.println("-------------------------------------------------------------------------");
            } else if (choice == 2) {
                System.out.print("Enter Employee ID to update salary: ");
                int id = getIntInput();
                Employee found = null;
                for (Employee e : employees) {
                    if (e.id == id) {
                        found = e;
                        break;
                    }
                }
                if (found != null) {
                    System.out.print("Enter New Base Salary: ");
                    found.baseSalary = getDoubleInput();
                    System.out.println("Salary updated successfully!");
                } else {
                    System.out.println("Employee ID not found.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    // =========================================================================
    // Q108: MARKSHEET GENERATION SYSTEM
    // =========================================================================
    private static void marksheetMenu() {
        if (students.isEmpty()) {
            System.out.println("\n[Note] Please add students in the Student Record Management System first.");
            return;
        }

        System.out.print("\nEnter Student ID to generate marksheet: ");
        int id = getIntInput();
        Student found = null;
        for (Student s : students) {
            if (s.id == id) {
                found = s;
                break;
            }
        }

        if (found == null) {
            System.out.println("Student ID not found.");
            return;
        }

        // input marks for 3 subjects if not already assigned
        System.out.println("Enter marks out of 100 for " + found.name + ":");
        System.out.print("Mathematics: ");
        found.mathMarks = getDoubleInput();
        System.out.print("Science: ");
        found.scienceMarks = getDoubleInput();
        System.out.print("English: ");
        found.englishMarks = getDoubleInput();

        // Calculate grades
        double total = found.mathMarks + found.scienceMarks + found.englishMarks;
        double percentage = total / 3.0;
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 75) grade = "A";
        else if (percentage >= 50) grade = "B";
        else if (percentage >= 35) grade = "C";
        else grade = "Fail";

        // Display formatted report card
        System.out.println("\n======================================");
        System.out.println("         OFFICIAL MARKSHEET           ");
        System.out.println("======================================");
        System.out.println("Student ID   : " + found.id);
        System.out.println("Student Name : " + found.name);
        System.out.println("--------------------------------------");
        System.out.printf("Mathematics  : %.2f / 100\n", found.mathMarks);
        System.out.printf("Science      : %.2f / 100\n", found.scienceMarks);
        System.out.printf("English      : %.2f / 100\n", found.englishMarks);
        System.out.println("--------------------------------------");
        System.out.printf("Total Marks  : %.2f / 300\n", total);
        System.out.printf("Percentage   : %.2f%%\n", percentage);
        System.out.println("Final Grade  : " + grade);
        System.out.println("======================================");
    }

    // Dynamic Blueprint Objects
    static class Student {
        int id;
        String name;
        double mathMarks, scienceMarks, englishMarks;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name;
        }
    }

    static class Employee {
        int id;
        String name;
        String designation;
        double baseSalary;

        Employee(int id, String name, String designation, double baseSalary) {
            this.id = id;
            this.name = name;
            this.designation = designation;
            this.baseSalary = baseSalary;
        }
    }
}
