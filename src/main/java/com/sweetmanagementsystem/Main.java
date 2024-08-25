package com.sweetmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sweetmanagementsystem.account.Account;
import com.sweetmanagementsystem.account.AccountManagementService;
import com.sweetmanagementsystem.management.Admin;
import com.sweetmanagementsystem.management.StoreOwner;
import com.sweetmanagementsystem.management.Supplier;
import com.sweetmanagementsystem.management.User;
import com.sweetmanagementsystem.management.UserManagementSystem;
import com.sweetmanagementsystem.order.Order;
import com.sweetmanagementsystem.order.OrderManagementService;
import com.sweetmanagementsystem.product.Product;
import com.sweetmanagementsystem.product.ProductManagementService;
import com.sweetmanagementsystem.user.UserAccount;
import com.sweetmanagementsystem.user.UserAccountService;

public class Main {

    private static UserManagementSystem userManagementSystem = new UserManagementSystem();
    private static ProductManagementService productManagementService = new ProductManagementService();
    private static OrderManagementService orderManagementService = new OrderManagementService();
    private static UserAccountService userAccountService = new UserAccountService();
    private static AccountManagementService accountManagementService = new AccountManagementService();
    private static Admin admin = new Admin("Rand", "Rand@123");

    public static void main(String[] args) {
        initializeDefaultUsers();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Sweet Management System!");

        while (true) {
            System.out.println("\nPlease choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Store Owner");
            System.out.println("3. Supplier");
            System.out.println("4. Beneficiary User");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (choice) {
                case 1:
                    adminLogin(scanner);
                    break;
                case 2:
                    storeOwnerLogin(scanner);
                    break;
                case 3:
                    supplierLogin(scanner);
                    break;
                case 4:
                    userLogin(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the Sweet Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Initialize default users for the system
    private static void initializeDefaultUsers() {
        StoreOwner defaultStoreOwner = new StoreOwner("defaultStoreOwner", "password123");
        Supplier defaultSupplier = new Supplier("defaultSupplier", "password456");

        userManagementSystem.addUser(defaultStoreOwner);
        userManagementSystem.addUser(defaultSupplier);

        UserAccount defaultUser = new UserAccount("defaultUser", "userpassword");
        userAccountService.registerUser(defaultUser);

        System.out.println("Default users initialized.");
    }

    // Admin login and actions
    private static void adminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            System.out.println("Admin logged in successfully!");
            adminActions(scanner);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void adminActions(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Actions:");
            System.out.println("1. Manage Users");
            System.out.println("2. Monitor Profits and Generate Reports");
            System.out.println("3. Manage Content");
            System.out.println("4. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (choice) {
                case 1:
                    manageUsers(scanner);
                    break;
                case 2:
                    monitorProfits(scanner);
                    break;
                case 3:
                    manageContent(scanner);
                    break;
                case 4:
                    System.out.println("Admin logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Store Owner login and actions
    private static void storeOwnerLogin(Scanner scanner) {
        System.out.print("Enter store owner username: ");
        String username = scanner.nextLine();
        System.out.print("Enter store owner password: ");
        String password = scanner.nextLine();

        StoreOwner storeOwner = new StoreOwner(username, password);
        if (userManagementSystem.userExists(username) && storeOwner.login(username, password)) {
            System.out.println("Store owner logged in successfully!");
            storeOwnerActions(scanner, storeOwner);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void storeOwnerActions(Scanner scanner, StoreOwner storeOwner) {
        while (true) {
            System.out.println("\nStore Owner Actions:");
            System.out.println("1. Manage Products");
            System.out.println("2. Process Orders");
            System.out.println("3. Update Account Information");
            System.out.println("4. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (choice) {
                case 1:
                    manageProducts(scanner, storeOwner);
                    break;
                case 2:
                    processOrders(scanner, storeOwner);
                    break;
                case 3:
                    updateAccount(scanner, storeOwner);
                    break;
                case 4:
                    System.out.println("Store owner logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Supplier login and actions
    private static void supplierLogin(Scanner scanner) {
        System.out.print("Enter supplier username: ");
        String username = scanner.nextLine();
        System.out.print("Enter supplier password: ");
        String password = scanner.nextLine();

        Supplier supplier = new Supplier(username, password);
        if (userManagementSystem.userExists(username) && supplier.login(username, password)) {
            System.out.println("Supplier logged in successfully!");
            supplierActions(scanner, supplier);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void supplierActions(Scanner scanner, Supplier supplier) {
        while (true) {
            System.out.println("\nSupplier Actions:");
            System.out.println("1. Manage Products");
            System.out.println("2. Update Account Information");
            System.out.println("3. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (choice) {
                case 1:
                    manageProducts(scanner, supplier);
                    break;
                case 2:
                    updateAccount(scanner, supplier);
                    break;
                case 3:
                    System.out.println("Supplier logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // User login and actions (Beneficiary User)
    private static void userLogin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userAccountService.loginUser(username, password)) {
            System.out.println("User logged in successfully!");
            userActions(scanner, userAccountService.getUserAccount(username));
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void userActions(Scanner scanner, UserAccount userAccount) {
        while (true) {
            System.out.println("\nUser Actions:");
            System.out.println("1. Share Dessert Creation");
            System.out.println("2. Explore and Purchase Desserts");
            System.out.println("3. Log Out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // read newline

            switch (choice) {
                case 1:
                    System.out.print("Enter dessert creation: ");
                    String dessert = scanner.nextLine();
                    userAccount.shareDessertCreation(dessert);
                    System.out.println("Dessert shared: " + dessert);
                    break;
                case 2:
                    exploreAndPurchaseDesserts(scanner, userAccount);
                    break;
                case 3:
                    System.out.println("User logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Utility methods for managing various features

    private static void manageUsers(Scanner scanner) {
        System.out.println("\nManaging users...");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.println("3. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (choice) {
            case 1:
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                User newUser = new User(username, password);
                userManagementSystem.addUser(newUser);
                System.out.println("User added successfully.");
                break;
            case 2:
                userManagementSystem.printAllUsers();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void monitorProfits(Scanner scanner) {
        System.out.println("\nMonitoring profits and generating reports...");
        System.out.println("1. View Sales Reports");
        System.out.println("2. View Best-Selling Products");
        System.out.println("3. View User Statistics by City");
        System.out.println("4. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (choice) {
            case 1:
                System.out.println("Displaying sales reports...");
                //I need to Implement sales report logic here
                break;
            case 2:
                System.out.println("Displaying best-selling products...");
                //I need to Implement best-selling product logic here
                break;
            case 3:
                System.out.println("Displaying user statistics by city...");
                //I need to Implement user statistics logic here
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void manageContent(Scanner scanner) {
        System.out.println("\nManaging content...");
        System.out.println("1. Approve Recipes");
        System.out.println("2. Manage Feedback");
        System.out.println("3. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (choice) {
            case 1:
                System.out.println("Approving recipes...");
                //I need to Implement recipe approval logic here
                break;
            case 2:
                System.out.println("Managing feedback...");
                //I need to Implement feedback management logic here
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void manageProducts(Scanner scanner, User user) {
        System.out.println("\nManaging products for user: " + user.getUsername());
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. View All Products");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // read newline
                Product product = new Product(productName, price,10);
                productManagementService.addProduct(product);
                System.out.println("Product added: " + productName);
                break;
            case 2:
                System.out.println("Update product logic here...");
                //I need to Implement update logic
                break;
            case 3:
                System.out.println("Remove product logic here...");
                //I need to Implement remove logic
                break;
            case 4:
                productManagementService.printAllProducts();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void processOrders(Scanner scanner, User user) {
        System.out.println("\nProcessing orders for user: " + user.getUsername());
        System.out.println("1. View Pending Orders");
        System.out.println("2. Update Order Status");
        System.out.println("3. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // read newline

        switch (choice) {
            case 1:
                System.out.println("Viewing pending orders...");
                //I need to Implement logic to display pending orders
                break;
            case 2:
                System.out.print("Enter order ID to update: ");
                String orderId = scanner.nextLine(); 
                System.out.print("Enter new order status: ");
                String status = scanner.nextLine();
                Order order = orderManagementService.getOrder(orderId); 

                if (order != null) {
                    orderManagementService.updateOrderStatus(orderId, status);
                    System.out.println("Order status updated to: " + status);
                } else {
                    System.out.println("Order not found.");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void exploreAndPurchaseDesserts(Scanner scanner, UserAccount userAccount) {
        System.out.println("Exploring and purchasing desserts...");
        //I need to Implement logic to explore and purchase desserts here
    }

    private static void updateAccount(Scanner scanner, User user) {
        System.out.print("Enter new business name: ");
        String businessName = scanner.nextLine();
        System.out.print("Enter new contact email: ");
        String contactEmail = scanner.nextLine();

        Account account = accountManagementService.getAccount(user.getUsername());
        account.setBusinessName(businessName);
        account.setContactEmail(contactEmail);

        System.out.println("Account updated for " + user.getUsername());
    }
}
