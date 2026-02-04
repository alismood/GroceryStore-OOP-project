package menu;

import database.ProductDAO;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import database.*;
public class Storage implements Menu {
    private ArrayList<Product> inventory;
    private Scanner scanner;
    private ProductDAO productDAO;

    public Storage() {
        this.inventory = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.productDAO = new ProductDAO();

        //Test data
        try {
            inventory.add(new FreshProduct(101, "Milk", 750.0, 20, "2026-02-15", 4.0));
            inventory.add(new PackagedProduct(201, "Cookie", 450.0, 50, "12345"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
// displaymenu
    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("      GROCERY STORE INVENTORY SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Fresh Product(week 7-8 assignment");
        System.out.println("2. Add Packaged Product");
        System.out.println("3. View All Inventory");
        System.out.println("4. View Fresh Products Only(week 7-8 assignment");
        System.out.println("5. Run Quality Checks (Polymorphism)");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1: addFreshProduct(); break;
                    case 2: addPackagedProduct(); break;
                    case 3: viewAllInventory(); break;
                    case 4: viewFreshProductsOnly(); break;
                    case 5: demonstratePolymorphism(); break;
                    case 0: running = false; break;
                    default: System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number!");
                scanner.nextLine(); // Clear the bad input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void addFreshProduct() {
        try {
            System.out.println("\n--- Adding Fresh Product ---");
            System.out.print("ID: "); int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Price: "); double price = scanner.nextDouble();
            System.out.print("Stock: "); int stock = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Expiration Date (YYYY-MM-DD): "); String date = scanner.nextLine();
            System.out.print("Storage Temp: "); double temp = scanner.nextDouble();



            FreshProduct freshProduct = new FreshProduct(id, name, price, stock, date, temp);
            productDAO.insertFreshProduct(freshProduct);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format!");
            scanner.nextLine();
        }
    }

    private void addPackagedProduct() {
        try {
            System.out.println("\n--- Adding Packaged Product ---");
            System.out.print("ID: "); int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Price: "); double price = scanner.nextDouble();
            System.out.print("Stock: "); int stock = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Barcode: "); String barcode = scanner.nextLine();

            inventory.add(new PackagedProduct(id, name, price, stock, barcode));
            System.out.println("Packaged product added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format!");
            scanner.nextLine();
        }
    }

    private void viewAllInventory() {
        System.out.println("\n--- FULL INVENTORY LIST ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is currently empty.");
            return;
        }
        for (Product p : inventory) {
            System.out.println(p.toString());
            // Checking for specific subclass alerts
            if (p instanceof FreshProduct fp) {
                if (fp.isHighlyPerishable()) {
                    System.out.println("ALERT: Keep in refrigerator!");
                }
            }
        }
    }

    private void viewFreshProductsOnly() {
        System.out.println("\n--- FRESH PRODUCE FILTER ---");
        boolean found = false;
        for (Product p : inventory) {
            if (p instanceof FreshProduct) {
                System.out.println(p);
                found = true;
                productDAO.getAllFreshProduct();
            }
        }
        if (!found) System.out.println("No fresh products found.");
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- QUALITY CHECK (POLYMORPHISM) ---");
        if (inventory.isEmpty()) {
            System.out.println("Nothing to check.");
            return;
        }
        for (Product p : inventory) {
            System.out.println("Checking " + p.getName() + ": " + p.toString());
        }
        System.out.println("Quality check complete.");
    }
}