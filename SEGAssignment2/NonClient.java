import java.util.Date;

public class NonClient {
    private String nonClientId;
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private int netWorth;
    private String externalBank;

    public NonClient(String nonClientId, String name, Date dateOfBirth, String phoneNumber, int netWorth, String externalBank) {
        this.nonClientId = nonClientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.netWorth = netWorth;
        this.externalBank = externalBank;
    }

    public String getNonClientId() {
        return nonClientId;
    }

    public void setNonClientId(String nonClientId) {
        if (nonClientId == null || nonClientId.isEmpty()) {
            System.out.println("Non-client ID invalid.");
            return;
        }
        this.nonClientId = nonClientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            System.out.println("Date of birth cannot be null.");
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println("Phone number invalid.");
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }

    public String getExternalBank() {
        return externalBank;
    }

    public void setExternalBank(String externalBank) {
        if (externalBank == null) {
            System.out.println("External bank cannot be null.");
            return;
        }
        this.externalBank = externalBank;
    }
}
