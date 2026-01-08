import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        products.add(new Product(1, "Apple", 2.0, 50));
        products.add(new Product(2, "Candy", 5.0, 10));
        customers.add(new Customer(101, "Ali", 5, 70));

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline [cite: 521, 558]

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewAllProducts(); break;
                case 3: addCustomer(); break;
                case 4: viewAllCustomers(); break;
                case 0:
                    System.out.println("Exiting... Goodbye! 👋");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Step 4: Display Menu [cite: 564]
    private static void displayMenu() {
        System.out.println("\n=== RESTAURANT MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // Step 5: Add Entity methods [cite: 567, 585]
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();

        products.add(new Product(id, name, price, qty));
        System.out.println("Product added successfully! ✅");
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Membership Level: ");
        int level = scanner.nextInt();
        System.out.print("Enter Total Purchases: ");
        int purchases = scanner.nextInt();

        customers.add(new Customer(id, name, level, purchases));
        System.out.println("Customer added successfully! ✅");
    }

    // Step 6: View Entity methods [cite: 575, 585]
    private static void viewAllProducts() {
        System.out.println("\n--- ALL PRODUCTS ---");
        if (products.isEmpty()) System.out.println("No products found.");
        for (Product p : products) System.out.println(p);
    }

    private static void viewAllCustomers() {
        System.out.println("\n--- ALL CUSTOMERS ---");
        if (customers.isEmpty()) System.out.println("No customers found.");
        for (Customer c : customers) System.out.println(c);
    }
}