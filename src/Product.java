public class Product {
    private int procutId;
    private String name;
    private int stockQuantity;
    private double price;


    public Product(int procutId, String name, double price, int stockQuantity){
        this.procutId = procutId;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public Product(){
        this.procutId = 0;
        this.name = "unknown item";
        this.stockQuantity = 0;
        this.price = 0;
    }

    public int getProcutId(){
        return procutId;
    }
    public String getName(){
        return name;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }
    public double getPrice(){
        return price;
    }


    public void setProcutId(int procutId){
        this.procutId = procutId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    public  void setPrice(double price){
        this.price = price;
    }


    public boolean isInStock(){
    if (this.stockQuantity > 0){
        return true;
    }
    else return false;
    }

    public void restock(int number){
        this.stockQuantity += number;
    }



    @Override
    public String  toString(){
        return "Product{ProductID="+ procutId + ", Name="+ name + ", Price=" + price + ", StockQuantity=" + stockQuantity + ", IsInStock=" + isInStock() + "}";
    }
}
