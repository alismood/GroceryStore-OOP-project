public class Product {
    private int productId;
    private String name;
    private int stockQuantity;
    private double price;

    // Constructor calling setters for validation
    public Product(int productId, String name, double price, int stockQuantity) {
        setProductId(productId);
        setName(name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public Product() {
        this.productId = 0;
        this.name = "unknown item";
        this.stockQuantity = 0;
        this.price = 0;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public int getStockQuantity() { return stockQuantity; }
    public double getPrice() { return price; }

    // Setters with validation [cite: 337, 366]
    public void setProductId(int productId) {
        if (productId > 0) this.productId = productId;
        else {
            System.out.println("Warning: Product ID must be positive.");
            this.productId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) this.stockQuantity = stockQuantity;
        else {
            System.out.println("Warning: Stock quantity cannot be negative.");
            this.stockQuantity = 0;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
        else {
            System.out.println("Warning: Price cannot be negative!");
            this.price = 0;
        }
    }

    public boolean isInStock() {
        return this.stockQuantity > 0;
    }

    public void restock(int number) {
        if (number > 0) this.stockQuantity += number;
        else System.out.println("Restock amount must be positive.");
    }

    @Override
    public String toString() {
        return "Product{ID=" + productId + ", Name=" + name + ", Price=" + price +
                ", Stock=" + stockQuantity + ", InStock=" + isInStock() + "}";
    }
}