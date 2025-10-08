public class ChequingAccount extends BankAccount {
    private String nickName;

    public ChequingAccount(int accountNumber, double balance, Client owner, String nickName) {
        super(accountNumber, balance, owner);
        this.nickName = nickName;
    }

    @Override
    public String displayInfo() {
        return "ChequingAccount[id=" + getId() + ", balance=" + getBalance() + ", nickName=" + nickName + "]";
    }
}
