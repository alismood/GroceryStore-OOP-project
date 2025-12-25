import  java.util.ArrayList;
void main() {
    System.out.println("=== Restaurant Management System ===");
    System.out.println();
    Product pr1 = new Product(1, "Apple",2, 10);
    Product pr2 = new Product();
    Product pr3 = new Product(3, "Candy",5, 0);

    Sale sale1 = new  Sale();
    Sale sale = new Sale(101, "Ali",2, "2025-10-12");

    Customer customer1 = new Customer(1, "Ali", 5, 70);
    Customer customer2 = new Customer(2, "Ereke", 3, 101);

    System.out.println("--- Products ---");
    System.out.println(pr1);
    System.out.println(pr2);
    System.out.println(pr3);
    System.out.println();
    System.out.println("--- Sales ---");
    System.out.println(sale);
    System.out.println(sale1);
    System.out.println();
    System.out.println("--- CUSTOMERS ---");
    System.out.println(customer1);
    System.out.println(customer2);
    System.out.println();


    System.out.println("--- TESTING GETTERS ---");
    System.out.println("Product name: " + pr1.getName());
    System.out.println("Product price: " + pr3.getPrice() + " KZT");
    System.out.println("Is custormer VIP: " + customer2.isVIP());
    System.out.println("Customer level: " + customer1.getMembershipLevel());
    System.out.println();

    System.out.println("--- TESTING SETTERS ---");
    System.out.println("Updating product2...");
    pr2.setProcutId(2);
    pr2.setName("Kazy");
    pr2.setPrice(4500.0);
    pr2.setStockQuantity(10);
    System.out.println("Updated: " + pr2);
    System.out.println();
    System.out.println("Changing sale1 customer...");
    sale1.setCustomerName("Peter Parker");
    sale1.setSaleId(2);
    sale1.setDate("10-12-2025");
    sale1.setTotalAmount(5);
    System.out.println("Updated: " + sale1);
    System.out.println();

    System.out.println("--- TESTING PRODUCT METHODS ---");
    System.out.println(pr3.getName() + " is in stock: " + pr3.isInStock());
    System.out.println("Restocking " + pr3.getName());
    pr3.restock(10);
    System.out.println("New quantity: " + pr3.getStockQuantity());
    System.out.println();

    System.out.println("--- TESTING SALE METHODS ---");
    System.out.println("Adding items to our list");
    sale.addItem(pr1);
    sale.addItem(pr3);
    System.out.println("Total: " + sale.calculateTotal());

    System.out.println("--- TESTING CUSTOMER METHODS ---");
    System.out.println(customer1.getName() + " is VIP: " + customer1.isVIP());
    System.out.println(customer2.getName() + " is VIP: " + customer2.isVIP());
    System.out.println();
    System.out.println("Adding 60 purchases to " + customer1.getName());
    customer1.addPurchase(60);
    System.out.println(customer1.getName() + " purchases: " + customer1.getTotalPurchases());
    System.out.println(customer1.getName() + " is VIP: " + customer1.isVIP());
    System.out.println();

    System.out.println("--- FINAL STATE ---");
    System.out.println("Products:");
    System.out.println(pr1);
    System.out.println(pr2);
    System.out.println(pr3);
    System.out.println();
    System.out.println("Sales:");
    System.out.println(sale);
    System.out.println(sale1);
    System.out.println();
    System.out.println("Customers:");
    System.out.println(customer1);
    System.out.println(customer2);
    System.out.println("\n=== Program Complete ===");
}
