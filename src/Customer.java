public class Customer {
    private int custormerId;
    private String name;
    private int membershipLevel;
    private int totalPurchases;

    public Customer(int custormerId, String name, int membershipLevel, int totalPurchases){
        this.custormerId = custormerId;
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.totalPurchases =  totalPurchases;
    }

    public Customer(){
        this.custormerId = 0;
        this.name = "unknown name";
        this.membershipLevel = 0;
        this.totalPurchases =  0;
    }

    public int getCustormerId(){
        return custormerId;
    }
    public String getName(){
        return name;
    }
    public int getMembershipLevel(){
        return membershipLevel;
    }
    public int getTotalPurchases(){
        return totalPurchases;
    }

    public void setCustormerId(int custormerId){
        this.custormerId =custormerId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMembershipLevels(int membershipLevel){
        this.membershipLevel = membershipLevel;
    }
    public void setTotalPurchases(int totalPurchases){
        this.totalPurchases = totalPurchases;
    }

    public boolean isVIP(){
        if (this.totalPurchases > 100)
            return true;
        else
            return  false;
    }

    public void addPurchase(int number){
        this.totalPurchases += number;
    }

    @Override
    public String toString(){
        return "Customer{CustomerID=" + custormerId + ", Name=" + name + "Level=" + membershipLevel + "TotalPurchases=" + totalPurchases + "}";
    }
}
