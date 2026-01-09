public class PackagedProduct extends Product {
    private String barcode;

    public PackagedProduct(int productId, String name, double price, int stockQuantity, String barcode) {
        super(productId, name, price, stockQuantity);
        this.barcode = barcode;
    }
    @Override
    public void performQualityCheck() {
        System.out.println("Scanning barcode (" + barcode + ") and checking packaging integrity for " + name);
    }
    @Override
    public String getCategory() {
        return "Packaged Good";
    }
    public void printShippingLabel() {
        System.out.println("Shipping Label:" + name + "ID: " + productId + "Barcode: " + barcode);
    }
    public boolean isBulkPackage() {
        return name.toLowerCase().contains("pack") || name.toLowerCase().contains("bulk");
    }
    @Override
    public String toString() {
        return super.toString() + "Barcode: " + barcode;
    }
}