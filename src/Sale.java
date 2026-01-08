import java.util.ArrayList;

public class Sale {
    private int saleId;
    private String customerName;
    private int totalAmount;
    private String date;
    private ArrayList<Product> items;

    public Sale(int saleId, String customerName, int totalAmount, String date) {
        setSaleId(saleId);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setDate(date);
        this.items = new ArrayList<>();
    }

    public Sale() {
        this.saleId = 0;
        this.customerName = "Unknown";
        this.totalAmount = 0;
        this.date = "Unknown";
        this.items = new ArrayList<>();
    }

    public void setSaleId(int saleId) { this.saleId = Math.max(saleId, 0); }
    public void setCustomerName(String name) {
        if (name != null && !name.trim().isEmpty()) this.customerName = name;
    }
    public void setTotalAmount(int amount) { this.totalAmount = Math.max(amount, 0); }
    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) this.date = date;
    }

//    public void addItem(Product product) {
//        if (product.isInStock()) items.add(product);
//        else System.out.println("Item out of stock!");
//    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) total += p.getPrice();
        return total;
    }

    @Override
    public String toString() {
        return "Sale{ID=" + saleId + ", Customer=" + customerName + ", Amount=" + totalAmount + "}";
    }
}