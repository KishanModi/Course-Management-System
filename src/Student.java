import java.time.LocalDate; // import the LocalDate class

public class Student extends Person{
    Boolean isInternational = false;
    int enrollmentNumber;
    protected final LocalDate dateOfEnrollment;

    public Student(String firstName, String lastName, LocalDate birthDate, long phoneNumber, String email,
                   Boolean isInternational, int enrollmentNumber, LocalDate dateOfEnrollment) {
        super(firstName, lastName, birthDate, phoneNumber, email);
        this.isInternational = isInternational;
        this.enrollmentNumber = enrollmentNumber;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "isInternational=" + isInternational +
                ", enrollmentNumber=" + enrollmentNumber +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
