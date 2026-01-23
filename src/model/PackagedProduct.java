package model;

public class PackagedProduct extends Product implements IEdible {
    private String barcode;

    public PackagedProduct(int productId, String name, double price, int stockQuantity, String barcode) {
        super(productId, name, price, stockQuantity);
        setBarcode(barcode);
    }
//Setters
    public void setBarcode(String code){
        if (code == null || code.trim().isEmpty()){
            throw new IllegalArgumentException("Barcode cannot be empty!");
        }
        else {
            this.barcode = code;
        }
    }
//Getters
    public String getBarcode(){
        return barcode;
    }

//Specific methods
    public void printShippingLabel() {
        System.out.println("Shipping Label:" + name + "ID: " + productId + "Barcode: " + barcode);
    }
    public boolean isBulkPackage() {
        return name.toLowerCase().contains("pack") || name.toLowerCase().contains("bulk");
    }


//Abstract methods
    @Override
    public String getCategory() {
        return "Packaged Good";
    }
    @Override
    public void needsRestock(){
        if(this.stockQuantity < 10){
            System.out.println("Close to the end");
        }
        else {
            System.out.println("Don't worry about restock");
        }
    }

//Interface method(IEdible)
    @Override
    public void edible(){
        System.out.println("This product is not edible");
    }

//Display Info
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Barcode: " + barcode);
        System.out.println("PackagedProduct");
    }
    @Override
    public String toString() {
        return super.toString() + "Barcode: " + barcode;
    }
}