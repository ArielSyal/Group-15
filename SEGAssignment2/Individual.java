import java.util.Date;

public class Individual extends Adult {
    private String occupation;
    private String maritalStatus;

    public Individual(String clientId, String name, String address, Date dateOfBirth, String phoneNumber,
                      double income, String occupation, String maritalStatus) {
        super(clientId, name, address, dateOfBirth, phoneNumber, income);
        this.occupation = occupation;
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        if (occupation == null) {
            System.out.println("Occupation cannot be null.");
            return;
        }
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        if (maritalStatus == null) {
            System.out.println("Marital status cannot be null.");
            return;
        }
        this.maritalStatus = maritalStatus;
    }
}
