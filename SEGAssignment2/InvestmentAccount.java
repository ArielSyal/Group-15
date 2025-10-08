public class InvestmentAccount extends BankAccount {
    private String nickName;

    public InvestmentAccount(int accountNumber, double balance, Client owner, String nickName) {
        super(accountNumber, balance, owner);
        this.nickName = nickName;
    }

    @Override
    public String displayInfo() {
        return "InvestmentAccount[id=" + getId() + ", balance=" + getBalance() + ", nickName=" + nickName + "]";
    }
}
