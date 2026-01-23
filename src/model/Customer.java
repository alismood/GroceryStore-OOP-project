package model;

public class Customer {
    private int customerId;
    private String name;
    private int membershipLevel;
    private int totalPurchases;

    public Customer(int customerId, String name, int membershipLevel, int totalPurchases) {
        setCustomerId(customerId);
        setName(name);
        setMembershipLevel(membershipLevel);
        setTotalPurchases(totalPurchases);
    }

    public Customer() {
        this.customerId = 0;
        this.name = "unknown name";
        this.membershipLevel = 0;
        this.totalPurchases = 0;
    }

    public int getCustomerId() {return customerId;}
    public String getName() {return name;}
    public int getMembershipLevel() {return membershipLevel;}
    public int getTotalPurchases() {return totalPurchases;}

    public void setCustomerId(int customerId) {
        if (customerId > 0) this.customerId = customerId;
        else this.customerId = 0;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Warning: Name cannot be empty!");
    }
    public void setMembershipLevel(int membershipLevel) {
        this.membershipLevel = (membershipLevel >= 0) ? membershipLevel : 0;
    }
    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = (totalPurchases >= 0) ? totalPurchases : 0;
    }
    public boolean isVIP() {
        return this.totalPurchases > 100;
    }
    public void addPurchase(int amount) {
        if (amount > 0) this.totalPurchases += amount;
    }
    @Override
    public String toString() {
        return "model.Customer{ID=" + customerId + ", Name=" + name +
                ", Level=" + membershipLevel + ", TotalPurchases=" + totalPurchases +
                ", VIP=" + isVIP() + "}";
    }
}