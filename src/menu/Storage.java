package menu;

import database.ProductDAO;
import model.*;
import java.util.ArrayList;
import java.util.List;
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
//        try {
//            inventory.add(new FreshProduct(101, "Milk", 750.0, 20, "2026-02-15", 4.0));
//            inventory.add(new PackagedProduct(201, "Cookie", 450.0, 50, "12345"));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
    }
// displaymenu
    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("      GROCERY STORE INVENTORY SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Fresh Product(Insert week 7)");
        System.out.println("2. Add Packaged Product(week 6)");
        System.out.println("3. View All Inventory(week6)");
        System.out.println("4. View Fresh Products Only(Select week 7)");
        System.out.println("5. Run Quality Checks (Polymorphism)");
        System.out.println("6. Update Fresh Product(Update week 8)");
        System.out.println("7. Delete Fresh Product by ID(Delete week 8)");
        System.out.println("8. Search by name(Search week 8)");
        System.out.println("9. Search by price range(search week 8)");
        System.out.println("10. Search by high price(Search week 8)");
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
                    case 6: updateFreshProduct(); break;
                    case 7: deleteFreshProduct(); break;
                    case 8: searchByName(); break;
                    case 9: searchBYPriceRange(); break;
                    case 10: searchBYPriceRange(); break;
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
//        System.out.println("\n--- FRESH PRODUCE FILTER ---");
//        boolean found = false;
//        for (Product p : inventory) {
//            if (p instanceof FreshProduct) {
//                System.out.println(p);
//                found = true;
                productDAO.getAllFreshProduct();
//            }
//        }
//        if (!found) System.out.println("No fresh products found.");
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

    private  void updateFreshProduct(){
        System.out.println("Enter freshproductID to update");
        int productid = scanner.nextInt();
        scanner.nextLine();

        FreshProduct existingFreshProduct = productDAO.getFreshProductById(productid);

        if (existingFreshProduct == null){
            System.out.println("No fresh Product with ID: " + productid);
            return;
        }

        System.out.println("| Current Info:");
        System.out.println("|" + existingFreshProduct.toString());
        System.out.println("|______________________________________________|");

        System.out.println("\n┌─ ENTER NEW VALUES ─────────────────────┐");
        System.out.println("│ (Press Enter to keep current value)   │");

//        System.out.println("| new ID [" + existingFreshProduct.getProductId() + "]: ");
//        String productIdInput = scanner.nextLine();
//        int newProductId = productIdInput.trim().isEmpty() ?
//                existingFreshProduct.getStockQuantity() : Integer.parseInt(productIdInput);

        System.out.println("| new name [" + existingFreshProduct.getName() + "]: ");
        String newName = scanner.nextLine();
        if (newName.trim().isEmpty()){
            newName = existingFreshProduct.getName();
        }

        System.out.println("| new Stock quantity [" + existingFreshProduct.getStockQuantity() + "]: ");
        String stockQuantityInput = scanner.nextLine();
        int newStockQuantity = stockQuantityInput.trim().isEmpty() ?
                existingFreshProduct.getStockQuantity() : Integer.parseInt(stockQuantityInput);

        System.out.println("| New Price [" + existingFreshProduct.getPrice() + "]: ");
        String priceInput = scanner.nextLine();
        double newPrice = priceInput.trim().isEmpty() ?
                existingFreshProduct.getPrice() : Double.parseDouble(priceInput);

        System.out.println("New expiration date [" + existingFreshProduct.getExpirationDate() + "]: ");
        String newExpirationDate = scanner.nextLine();
        if (newExpirationDate.trim().isEmpty()){
            newExpirationDate = existingFreshProduct.getExpirationDate();
        }

        System.out.println("New Sotage Temperature [" + existingFreshProduct.getStorageTemperature() + "]: ");
        String storageTemperatureInput = scanner.nextLine();
        double newStorageTemperature = storageTemperatureInput.trim().isEmpty() ?
                existingFreshProduct.getStorageTemperature() : Double.parseDouble(storageTemperatureInput);

        FreshProduct updatedFreshProduct = new FreshProduct(productid, newName, newPrice, newStockQuantity, newExpirationDate, newStorageTemperature);
        productDAO.updateFreshProduct(updatedFreshProduct);


        System.out.println("└────────────────────────────────────────┘");

    }

    private void deleteFreshProduct(){
        System.out.println("Enter Fresh Product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        FreshProduct product = productDAO.getFreshProductById(productId);

        if (product == null) {
            System.out.println("No Fresh Product deleted");
            return;
        }

        System.out.println("Fresh Product to delete: ");
        System.out.println(product.getProductId());

        System.out.println("Are you sure?(yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")){
            productDAO.deleteFreshProduct(productId);
        } else {
            System.out.println("Deletion cancelled");
        }
    }

    private void searchByName(){
        System.out.println("\n -------Search By Name -----------------");
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("-------------------------------------------");

        List<FreshProduct> freshProductList = productDAO.searchByName(name);

        displaySearchResults(freshProductList, "Search: '" + name + "'");
    }

    private void displaySearchResults(List<FreshProduct> freshProductList, String criteria){
        System.out.println("\n ---------------------------------");
        System.out.println("       Search REsults");
        System.out.println("-------------------------------------");
        System.out.println("Criteria: " + criteria);
        System.out.println("-------------------------------------");

        if (freshProductList.isEmpty()){
            System.out.println("No fresh Product matching criteria");
        } else {
            for(int i = 0; i < freshProductList.size(); i++){
                FreshProduct s = freshProductList.get(i);
                System.out.println((i + 1) + ". ");
                System.out.println(s.toString());
            }
            System.out.println("Total results: " + freshProductList.size());
        }
    }

    private void searchBYPriceRange(){
        try {
            System.out.println("\n┌─ SEARCH BY PRIce RANGE ───────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();

            System.out.println("Max price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("________________________________________________");
            List<FreshProduct> freshProductList = productDAO.searchByPriceRange(minPrice, maxPrice);

            displaySearchResults(freshProductList, "Price: " + minPrice + "--" + maxPrice + "KZT");
        } catch (java.util.InputMismatchException e){
            System.out.println("Error: Invalid Number!(Searchbyprice");
            scanner.nextLine();

        }
    }

    private void searchHighPriceFreshProduct(){
        try {
            System.out.println("\n -----HIGH PRICE FRESH PRODUCT");
            System.out.println(" ENter min price: ");
            double minPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("_________________________________");

            List<FreshProduct> freshProductList = productDAO.searchByMinPrice(minPrice);

            displaySearchResults(freshProductList, "price >=" + minPrice + "KZT");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: highprice sorage");
            scanner.nextLine();
        }
    }
}