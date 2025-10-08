import java.util.Date;

public class LargeBusiness extends Adult {
    private long taxNumber;
    private String industry;
    private int numberOfEmployees;

    public LargeBusiness(String clientId, String name, String address, Date dateOfBirth, String phoneNumber,
                         double income, long taxNumber, String industry, int numberOfEmployees) {
        super(clientId, name, address, dateOfBirth, phoneNumber, income);
        this.taxNumber = taxNumber;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }

    public long getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(long taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        if (industry == null) {
            System.out.println("Industry cannot be null.");
            return;
        }
        this.industry = industry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
