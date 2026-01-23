package model;

public class FreshProduct extends Product implements IEdible {
    private String expirationDate;
    private double storageTemperature;

    public FreshProduct(int productId, String name, double price, int stockQuantity, String expirationDate, double temperature) {
        super(productId, name, price, stockQuantity);
        setExpirationDate(expirationDate);
        setStorageTemperature(temperature);
    }
    //Getters
    public double getStorageTemperature(){
        return storageTemperature;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
    // Setters
    public void setStorageTemperature(double temp){
        if (-50.0 < temp && temp < 25.0){
            this.storageTemperature = temp;
        }
        else {
            throw new IllegalArgumentException("Unrealistic temperature");
        }
    }
    public void setExpirationDate(String date){
        if (date == null || date.trim().isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty");
        }
        else{
            this.expirationDate = date;
        }
    }
// Concrete methods
    public boolean isHighlyPerishable() {
        return storageTemperature < 5.0;}

    public void applyEndOfDayDiscount() {
        this.price = this.price * 0.7;
        System.out.println("Price of " + name + "reduced");}

//Interface method(IEdible)
    @Override
    public void edible(){
        System.out.println("This product is edible");
    }

//Abstract method
    @Override
    public String getCategory() {
        return "Fresh Produce";}

    @Override
    public void needsRestock() {
        if (this.stockQuantity < 3){
            System.out.println("Restock required");
        }
        else {
            System.out.println("Restock doesn't required");}}

//Dispaly Info
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Expiration_Date: " + expirationDate);
        System.out.println("Temperature: "+ storageTemperature);
        System.out.println("FRESH PRODUCTS");
    }

    @Override
    public String toString() {
        return super.toString() + " Expires: " + expirationDate + " Temp: " + storageTemperature + "C";
    }
}