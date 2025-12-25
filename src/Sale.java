import  java.util.ArrayList;
public class Sale {
    private int saleId;
    private String customerName;
    private  int totalAmount;
    private  String date;
    private ArrayList<Product> items;


//    public Sale(int saleId, String customerName, int totalAmount, String date){
//        this.saleId = saleId;
//        this.customerName = customerName;
//        this.totalAmount = totalAmount;
//        this.date = date;
//    }

    public  Sale(){
        this.saleId = 0;
        this.customerName = "UnknowName";
        this.totalAmount = 0;
        this.date = "UnknowDate";
    }

    public int getSaleId(){
        return saleId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getTotalAmount(){
        return totalAmount;
    }
    public String getDate(){
        return date;
    }

    public void setSaleId(int saleId){
        this.saleId = saleId;
    }
    public  void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setTotalAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
    public  void setDate(String date){
        this.date = date;
    }

    public Sale(int saleId, String customerName,int totalAmount, String date) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.date = date;
        this.totalAmount = totalAmount;
        this.items = new ArrayList<>(); // ← IMPORTANT
    }

    public void addItem(Product product) {
        if (product.isInStock()) {
            items.add(product);
        } else {
            System.out.println("Out of stock");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    @Override
    public String toString(){
        return "Sale{saleID=" + saleId + ", Name=" + customerName + ", Amount=" + totalAmount
                + "}";
    }

}
//Fields: saleId, customerName, totalAmount,
//date
//Methods: addItem(), calculateTotal()