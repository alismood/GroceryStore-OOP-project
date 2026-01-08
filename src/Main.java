import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inventory.add(new Product(1001, "Paper Bags", 50, 500));
        inventory.add(new FreshProduct(2001, "Milk", 450, 20, "2024-06-01", 4.0));
        inventory.add(new PackagedProduct(3001, "Cereal Pack", 1200, 15, "BAR-998877"));

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addGeneralProduct(); break;
                case 2: addFreshProduct(); break;
                case 3: addPackagedProduct(); break;
                case 4: viewAllInventory(); break;
                case 5: demonstratePolymorphism(); break;
                case 6: viewFreshProductsOnly(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nGROCERY STORE INVENTORY SYSTEM");
        System.out.println("1. Add General Product");
        System.out.println("2. Add Fresh Product (Child 1)");
        System.out.println("3. Add Packaged Product (Child 2)");
        System.out.println("4. View All Inventory (Polymorphic)");
        System.out.println("5. Run Quality Checks (Polymorphism Demo)");
        System.out.println("6. View Fresh Products Only (Type Filter)");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static void addGeneralProduct() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        System.out.print("Stock: "); int stock = scanner.nextInt();
        inventory.add(new Product(id, name, price, stock));
        System.out.println("General product added.");
    }

    private static void addFreshProduct() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        System.out.print("Stock: "); int stock = scanner.nextInt(); scanner.nextLine();
        System.out.print("Expiration Date (YYYY-MM-DD): "); String date = scanner.nextLine();
        System.out.print("Storage Temp: "); double temp = scanner.nextDouble();

        inventory.add(new FreshProduct(id, name, price, stock, date, temp));
        System.out.println("Fresh product added.");
    }

    private static void addPackagedProduct() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        System.out.print("Stock: "); int stock = scanner.nextInt(); scanner.nextLine();
        System.out.print("Barcode: "); String barcode = scanner.nextLine();

        inventory.add(new PackagedProduct(id, name, price, stock, barcode));
        System.out.println("Packaged product added.");
    }

    private static void viewAllInventory() {
        System.out.println("\nALL INVENTORY ITEMS:");
        for (Product p : inventory) {
            System.out.println(p);


            if (p instanceof FreshProduct) {
                FreshProduct fp = (FreshProduct) p;
                if (fp.isHighlyPerishable()) System.out.println("-> ALERT: Keep in refrigerator!");
            }
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\nDEMONSTRATING POLYMORPHISM:");
        for (Product p : inventory) {
            p.performQualityCheck();
        }
    }

    private static void viewFreshProductsOnly() {
        System.out.println("\nFRESH PRODUCE FILTER:");
        for (Product p : inventory) {
            if (p instanceof FreshProduct) {
                System.out.println(p.getName() + " (Stock: " + p.getStockQuantity() + ")");
            }
        }
    }
}