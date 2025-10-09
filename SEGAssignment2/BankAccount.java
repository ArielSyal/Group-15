
public abstract class BankAccount {
    private long id;
    private double balance;
    private Client owner;

    public BankAccount(long id, double balance, Client owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) { this.balance = balance; }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public abstract String displayInfo();
}
