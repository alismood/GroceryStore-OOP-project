public class Product {
    protected int productId;
    protected String name;
    protected int stockQuantity;
    protected double price;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
        setStockQuantity(stockQuantity);
    }


    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) this.stockQuantity = stockQuantity;
    }


    public void performQualityCheck() {
        System.out.println("Performing standard quality check for product: " + name);
    }


    public String getCategory() {
        return "General Product";
    }


    public boolean needsRestock() {
        return stockQuantity < 10;
    }

    @Override
    public String toString() {
        return "[" + getCategory() + "] ID: " + productId + ", Name: " + name +
                ", Price: " + price + " KZT, Stock: " + stockQuantity;
    }
}