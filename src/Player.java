public class Player {
    private String name;
    private int balance;

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  name + ": " + balance;
    }

    public int deposit(int x){
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }
}
