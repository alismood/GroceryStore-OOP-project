public class FreshProduct extends Product {
    private String expirationDate;
    private double storageTemperature;

    public FreshProduct(int productId, String name, double price, int stockQuantity,
                        String expirationDate, double temperature) {
        super(productId, name, price, stockQuantity);
        this.expirationDate = expirationDate;
        this.storageTemperature = temperature;
    }

    @Override
    public void performQualityCheck() {
        System.out.println("Checking freshness and expiration date (" + expirationDate + ") for " + name);
    }

    @Override
    public String getCategory() {
        return "Fresh Produce";
    }


    public boolean isHighlyPerishable() {
        return storageTemperature < 5.0;
    }

    public void applyEndOfDayDiscount() {
        this.price = this.price * 0.70;
        System.out.println("Price of " + name + " reduced for quick sale.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Expires: " + expirationDate + " | Temp: " + storageTemperature + "C";
    }
}