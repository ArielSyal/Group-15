import java.util.Date;

public class Minor extends Client {
    private String guardianName;
    private String guardianId;

    public Minor(String clientId, String name, String address, Date dateOfBirth, String phoneNumber,
                 String guardianName, String guardianId) {
        super(clientId, name, address, dateOfBirth, phoneNumber);
        this.guardianName = guardianName;
        this.guardianId = guardianId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        if (guardianName == null || guardianName.isEmpty()) {
            System.out.println("Guardian name cannot be empty.");
            return;
        }
        this.guardianName = guardianName;
    }

    public String getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(String guardianId) {
        if (guardianId == null || guardianId.isEmpty()) {
            System.out.println("Guardian ID cannot be empty.");
            return;
        }
        this.guardianId = guardianId;
    }
}
