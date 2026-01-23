package model;

public abstract class Product {
    protected int productId;
    protected String name;
    protected int stockQuantity;
    protected double price;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        setName(name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }


    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
        else{
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) this.stockQuantity = stockQuantity;
        else{
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    public void setName(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        else {
            this.name = name;
        }
    }
//Concrrete emthod
    public void displayInfo(){
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + stockQuantity);
        System.out.println("Price: " + price + "KZT");
    }

//Abstract method
    public abstract String getCategory();
    public abstract void needsRestock();

    @Override
    public String toString() {
        return "[" + getCategory() + "] ID: " + productId + ", Name: " + name +
                ", Price: " + price + ", Stock: " + stockQuantity;
    }
}