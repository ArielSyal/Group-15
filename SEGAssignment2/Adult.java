import java.util.Date;

public abstract class Adult extends Client {
    private double income;

    public Adult(String clientId, String name, String address, Date dateOfBirth, String phoneNumber, double income) {
        super(clientId, name, address, dateOfBirth, phoneNumber);
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
