public class InvestmentAccount extends BankAccount {
    private String nickName;

    public InvestmentAccount(long id, double balance, Client owner, String nickName) {
        super(id, balance, owner);
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
        return "InvestmentAccount[id=" + getId() + ", balance=" + getBalance() + ", nickName=" + nickName + "]";
    }
}