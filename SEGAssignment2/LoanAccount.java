public class LoanAccount extends BankAccount {
    private double interestRate;

    public LoanAccount(int accountNumber, double balance, Client owner, double interestRate) {
        super(accountNumber, balance, owner);
        this.interestRate = interestRate;
    }

    @Override
    public String displayInfo() {
        return "LoanAccount[id=" + getId() + ", balance=" + getBalance() + ", interestRate=" + interestRate + "]";
    }
}
