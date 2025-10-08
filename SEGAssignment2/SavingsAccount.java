public class SavingsAccount extends BankAccount {
    private String nickName;
    private double interestRate;

    public SavingsAccount(long id, double balance, Client owner, String nickName, double interestRate) {
        super(id, balance, owner);
        this.nickName = nickName;
        this.interestRate = interestRate;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    @Override
    public String displayInfo() {
        return "SavingsAccount[id=" + getId() + ", balance=" + getBalance() + ", nickName=" + nickName + ", interestRate=" + interestRate + "]";
    }
}