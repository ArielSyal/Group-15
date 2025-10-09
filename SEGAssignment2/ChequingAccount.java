public class ChequingAccount extends BankAccount {
    private String nickName;

    public ChequingAccount(int accountNumber, double balance, Client owner, String nickName) {
        super(accountNumber, balance, owner);
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String displayInfo() {
        return "ChequingAccount[id=" + getId() + ", balance=" + getBalance() + ", nickName=" + nickName + "]";
    }
}
