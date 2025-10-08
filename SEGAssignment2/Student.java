import java.util.Date;

public class Student extends Client {
    private String schoolName;
    private Date graduationDate;

    public Student(String clientId, String name, String address, Date dateOfBirth, String phoneNumber,
                   String schoolName, Date graduationDate) {
        super(clientId, name, address, dateOfBirth, phoneNumber);
        this.schoolName = schoolName;
        this.graduationDate = graduationDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        if (schoolName == null || schoolName.isEmpty()) {
            System.out.println("School name cannot be empty.");
            return;
        }
        this.schoolName = schoolName;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        if (graduationDate == null) {
            System.out.println("Graduation date cannot be empty.");
            return;
        }
        this.graduationDate = graduationDate;
    }
}
