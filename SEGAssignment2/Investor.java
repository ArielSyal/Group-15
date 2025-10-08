import java.util.Date;

public class Investor extends Adult {
    private String riskAppetite;
    private int experience;

    public Investor(String clientId, String name, String address, Date dateOfBirth, String phoneNumber,
                    double income, String riskAppetite, int experience) {
        super(clientId, name, address, dateOfBirth, phoneNumber, income);
        this.riskAppetite = riskAppetite;
        this.experience = experience;
    }

    public String getRiskAppetite() {
        return riskAppetite;
    }

    public void setRiskAppetite(String riskAppetite) {
        if (riskAppetite == null) {
            System.out.println("Risk appetite cannot be null.");
            return;
        }
        this.riskAppetite = riskAppetite;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
