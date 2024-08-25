package com.sweetmanagementsystem;

import java.util.Scanner;
import com.sweetmanagementsystem.management.Admin;
import com.sweetmanagementsystem.management.StoreOwner;
import com.sweetmanagementsystem.management.Supplier;
import com.sweetmanagementsystem.management.User;
import com.sweetmanagementsystem.management.UserManagementSystem;
import com.sweetmanagementsystem.user.UserAccount;
import com.sweetmanagementsystem.user.UserAccountService;

public class Main {

    private static UserAccountService userAccountService = new UserAccountService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sweet Management System!");
        System.out.println("Please select your role:");
        System.out.println("1. Admin");
        System.out.println("2. Store Owner");
        System.out.println("3. Supplier");
        System.out.println("4. User");
        System.out.println("5. Exit");

        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // newline

        switch (roleChoice) {
            case 1:
                adminActions(scanner);
                break;
            case 2:
                storeOwnerActions(scanner);
                break;
            case 3:
                supplierActions(scanner);
                break;
            case 4:
                userActions(scanner);
                break;
            case 5:
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
                break;
        }

        scanner.close();
    }

    private static void adminActions(Scanner scanner) {
        Admin admin = new Admin("adminUsername", "adminPassword");
        admin.login("adminUsername", "adminPassword");

        if (admin.isLoggedIn()) {
            System.out.println("Admin logged in successfully. Choose an action:");
            System.out.println("1. Monitor Profits");
            System.out.println("2. Generate Reports");
            System.out.println("3. Manage Users");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (adminChoice) {
                case 1:
                    System.out.println("Monitoring profits...");
                    //I need to Call profit monitoring method
                    break;
                case 2:
                    System.out.println("Generating reports...");
                    //I need to Call report generation method
                    break;
                case 3:
                    manageUsers(scanner, admin);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Admin login failed.");
        }
    }

    private static void manageUsers(Scanner scanner, Admin admin) {
        System.out.println("Choose user action:");
        System.out.println("1. Add User");
        System.out.println("2. View Users");
        int userChoice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (userChoice) {
            case 1:
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                UserAccount newUser = new UserAccount(username, password);
                userAccountService.registerUser(newUser);
                admin.addUser(new User(username, password));
                System.out.println("User added: " + username);
                break;
            case 2:
                UserManagementSystem.printAllUsers();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void storeOwnerActions(Scanner scanner) {
        StoreOwner storeOwner = new StoreOwner("storeOwnerUsername", "storeOwnerPassword");
        storeOwner.login("storeOwnerUsername", "storeOwnerPassword");

        if (storeOwner.isLoggedIn()) {
            System.out.println("Store Owner logged in successfully. Choose an action:");
            System.out.println("1. Manage Products");
            System.out.println("2. Process Orders");

            int storeOwnerChoice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (storeOwnerChoice) {
                case 1:
                    System.out.println("Managing products...");
                    //I need to Call product management methods
                    break;
                case 2:
                    System.out.println("Processing orders...");
                    //I need to Call order processing methods
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Store Owner login failed.");
        }
    }

    private static void supplierActions(Scanner scanner) {
        Supplier supplier = new Supplier("supplierUsername", "supplierPassword");
        supplier.login("supplierUsername", "supplierPassword");

        if (supplier.isLoggedIn()) {
            System.out.println("Supplier logged in successfully. Choose an action:");
            System.out.println("1. Manage Raw Materials");

            int supplierChoice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (supplierChoice) {
                case 1:
                    System.out.println("Managing raw materials...");
                    //I need to Call raw material management methods
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Supplier login failed.");
        }
    }

    private static void userActions(Scanner scanner) {
        System.out.println("Choose an action:");
        System.out.println("1. Sign up");
        System.out.println("2. Sign in");
        System.out.println("3. Share a Dessert Creation");

        int userChoice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (userChoice) {
            case 1:
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                UserAccount newUser = new UserAccount(username, password);
                userAccountService.registerUser(newUser);
                System.out.println("User signed up: " + username);
                break;
            case 2:
                System.out.println("Enter username:");
                username = scanner.nextLine();
                System.out.println("Enter password:");
                password = scanner.nextLine();
                if (userAccountService.loginUser(username, password)) {
                    System.out.println("User logged in successfully.");
                } else {
                    System.out.println("Invalid login credentials.");
                }
                break;
            case 3:
                System.out.println("Enter your username:");
                username = scanner.nextLine();
                System.out.println("Enter your dessert creation:");
                String dessert = scanner.nextLine();
                UserAccount userAccount = userAccountService.getUserAccount(username);
                if (userAccount != null) {
                    userAccount.shareDessertCreation(dessert);
                    System.out.println("Dessert shared successfully!");
                } else {
                    System.out.println("User not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
