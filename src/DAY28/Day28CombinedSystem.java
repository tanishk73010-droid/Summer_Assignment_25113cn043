package DAY28;

import java.util.ArrayList;
import java.util.Scanner;

public class Day28CombinedSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("    DAY 28: INTEGRATED SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Library Management System (Q109)");
            System.out.println("2. Bank Account System (Q110)");
            System.out.println("3. Ticket Booking System (Q111)");
            System.out.println("4. Contact Management System (Q112)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    runLibrarySystem();
                    break;
                case 2:
                    runBankSystem();
                    break;
                case 3:
                    runTicketSystem();
                    break;
                case 4:
                    runContactSystem();
                    break;
                case 5:
                    System.out.println("Exiting System. Happy Coding!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // =========================================================================
    // 1. Q109: LIBRARY MANAGEMENT SYSTEM
    // =========================================================================
    static class Book {
        String title;
        boolean isIssued;
        Book(String title) { this.title = title; this.isIssued = false; }
    }

    private static final ArrayList<Book> library = new ArrayList<>();

    private static void runLibrarySystem() {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 5) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter book title: ");
                    library.add(new Book(scanner.nextLine()));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    if (library.isEmpty()) System.out.println("Library is empty.");
                    for (int i = 0; i < library.size(); i++) {
                        Book b = library.get(i);
                        System.out.println((i + 1) + ". " + b.title + " [" + (b.isIssued ? "Issued" : "Available") + "]");
                    }
                    break;
                case 3:
                    System.out.print("Enter book index to issue: ");
                    int issueIdx = scanner.nextInt() - 1;
                    if (issueIdx >= 0 && issueIdx < library.size()) {
                        if (!library.get(issueIdx).isIssued) {
                            library.get(issueIdx).isIssued = true;
                            System.out.println("Book issued successfully!");
                        } else {
                            System.out.println("Book is already issued.");
                        }
                    } else System.out.println("Invalid index.");
                    break;
                case 4:
                    System.out.print("Enter book index to return: ");
                    int returnIdx = scanner.nextInt() - 1;
                    if (returnIdx >= 0 && returnIdx < library.size()) {
                        if (library.get(returnIdx).isIssued) {
                            library.get(returnIdx).isIssued = false;
                            System.out.println("Book returned successfully!");
                        } else {
                            System.out.println("Book was not issued.");
                        }
                    } else System.out.println("Invalid index.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 2. Q110: BANK ACCOUNT SYSTEM
    // =========================================================================
    private static double bankBalance = 1000.0; // Default opening balance

    private static void runBankSystem() {
        while (true) {
            System.out.println("\n--- Bank Account System ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();

            if (ch == 4) break;
            switch (ch) {
                case 1:
                    System.out.printf("Current Balance: $%.2f\n", bankBalance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = scanner.nextDouble();
                    if (dep > 0) {
                        bankBalance += dep;
                        System.out.println("Successfully deposited.");
                    } else System.out.println("Invalid amount.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = scanner.nextDouble();
                    if (wit > 0 && wit <= bankBalance) {
                        bankBalance -= wit;
                        System.out.println("Successfully withdrawn.");
                    } else System.out.println("Insufficient funds or invalid amount.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 3. Q111: TICKET BOOKING SYSTEM
    // =========================================================================
    private static final boolean[] seats = new boolean[10]; // 10 available seats (false = empty)

    private static void runTicketSystem() {
        while (true) {
            System.out.println("\n--- Ticket Booking System ---");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Cancel a Ticket");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();

            if (ch == 4) break;
            switch (ch) {
                case 1:
                    System.out.print("Seat Layout: ");
                    for (int i = 0; i < seats.length; i++) {
                        System.out.print("[" + (i + 1) + ":" + (seats[i] ? "B" : "E") + "] ");
                    }
                    System.out.println("\n(B = Booked, E = Empty)");
                    break;
                case 2:
                    System.out.print("Enter seat number (1-10) to book: ");
                    int bookSeat = scanner.nextInt() - 1;
                    if (bookSeat >= 0 && bookSeat < 10) {
                        if (!seats[bookSeat]) {
                            seats[bookSeat] = true;
                            System.out.println("Seat " + (bookSeat + 1) + " booked successfully!");
                        } else System.out.println("Seat already booked.");
                    } else System.out.println("Invalid seat number.");
                    break;
                case 3:
                    System.out.print("Enter seat number (1-10) to cancel: ");
                    int cancelSeat = scanner.nextInt() - 1;
                    if (cancelSeat >= 0 && cancelSeat < 10) {
                        if (seats[cancelSeat]) {
                            seats[cancelSeat] = false;
                            System.out.println("Reservation for seat " + (cancelSeat + 1) + " cancelled.");
                        } else System.out.println("Seat is already empty.");
                    } else System.out.println("Invalid seat number.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // =========================================================================
    // 4. Q112: CONTACT MANAGEMENT SYSTEM
    // =========================================================================
    static class Contact {
        String name, phone;
        Contact(String name, String phone) { this.name = name; this.phone = phone; }
    }

    private static final ArrayList<Contact> contacts = new ArrayList<>();

    private static void runContactSystem() {
        while (true) {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if (ch == 4) break;
            switch (ch) {
                case 1:
                    System.out.print("Enter Contact Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact saved successfully!");
                    break;
                case 2:
                    if (contacts.isEmpty()) System.out.println("No contacts found.");
                    for (Contact c : contacts) {
                        System.out.println("Name: " + c.name + " | Phone: " + c.phone);
                    }
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Found! Phone: " + c.phone);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Contact not found.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}