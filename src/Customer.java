public class Customer {
    private String name;
    private int balance;

    public Customer(String name, int balance){

        this.name = name;
        this.balance = balance;

    }

    @Override
    public String toString() {
        return  name + ": " + balance;
    }

    public void deposit(int amount){
        this.balance += amount;

    }
    public String getName() {
        return this.name;
    }
    public int getBalance() {
        return this.balance;
    }
}
