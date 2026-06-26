package DAY26;

import java.util.Random;
import java.util.Scanner;

public class Day26Program {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("      DAY 26 PROGRAM DASHBOARD   ");
            System.out.println("=================================");
            System.out.println("1. Q101: Number Guessing Game");
            System.out.println("2. Q102: Voting Eligibility System");
            System.out.println("3. Q103: ATM Simulation");
            System.out.println("4. Q104: Quiz Application");
            System.out.println("5. Exit");
            System.out.print("Choose a program to run (1-5): ");

            int choice = scanner.nextInt();
            System.out.println("---------------------------------");

            switch (choice) {
                case 1:
                    runNumberGuessingGame();
                    break;
                case 2:
                    runVotingEligibilitySystem();
                    break;
                case 3:
                    runATMSimulation();
                    break;
                case 4:
                    runQuizApplication();
                    break;
                case 5:
                    System.out.println("Exiting Day 26 programs. Happy coding!");
                    return;
                default:
                    System.out.println("Invalid choice. Please pick an option between 1 and 5.");
            }
        }
    }

    // =========================================================================
    // Q101: Number Guessing Game
    // =========================================================================
    private static void runNumberGuessingGame() {
        System.out.println("--- Q101: Number Guessing Game ---");
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generates number between 1 and 100
        int attempts = 0;
        int guess = 0;

        System.out.println("I have chosen a secret number between 1 and 100. Try to guess it!");

        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number (" + numberToGuess + ") in " + attempts + " attempts.");
            }
        }
    }

    // =========================================================================
    // Q102: Voting Eligibility System
    // =========================================================================
    private static void runVotingEligibilitySystem() {
        System.out.println("--- Q102: Voting Eligibility System ---");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("Invalid age entered!");
        } else if (age >= 18) {
            System.out.println("You are eligible to vote. Exercise your right responsibly!");
        } else {
            int yearsLeft = 18 - age;
            System.out.println("You are not eligible to vote yet. You need to wait " + yearsLeft + " more year(s).");
        }
    }

    // =========================================================================
    // Q103: ATM Simulation
    // =========================================================================
    private static void runATMSimulation() {
        System.out.println("--- Q103: ATM Simulation ---");
        double balance = 5000.0; // Hardcoded default initial balance
        boolean atmSession = true;

        while (atmSession) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit ATM");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Successfully deposited $%.2f. New Balance: $%.2f\n", deposit, balance);
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal > balance) {
                        System.out.println("Insufficient funds!");
                    } else if (withdrawal <= 0) {
                        System.out.println("Invalid withdrawal amount!");
                    } else {
                        balance -= withdrawal;
                        System.out.printf("Successfully withdrew $%.2f. Remaining Balance: $%.2f\n", withdrawal, balance);
                    }
                    break;
                case 4:
                    System.out.println("Exiting ATM Simulator. Thank you!");
                    atmSession = false;
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        }
    }

    // =========================================================================
    // Q104: Quiz Application
    // =========================================================================
    private static void runQuizApplication() {
        System.out.println("--- Q104: Quiz Application ---");
        int score = 0;

        // Question 1
        System.out.println("\nQ1. Which platform-independent component executes Java bytecode?");
        System.out.println("1. JDK\n2. JVM\n3. JRE\n4. Compiler");
        System.out.print("Your Answer (1-4): ");
        if (scanner.nextInt() == 2) {
            score++;
        }

        // Question 2
        System.out.println("\nQ2. Which of these is not a primitive data type in Java?");
        System.out.println("1. int\n2. boolean\n3. String\n4. char");
        System.out.print("Your Answer (1-4): ");
        if (scanner.nextInt() == 3) {
            score++;
        }

        // Question 3
        System.out.println("\nQ3. What is the size of an int data type in Java?");
        System.out.println("1. 1 byte\n2. 2 bytes\n3. 4 bytes\n4. 8 bytes");
        System.out.print("Your Answer (1-4): ");
        if (scanner.nextInt() == 3) {
            score++;
        }

        System.out.println("\n--- Quiz Finished! ---");
        System.out.println("Your Final Score: " + score + " out of 3");
    }
}