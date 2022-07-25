import java.time.LocalDate; // import the LocalDate class
import java.util.InputMismatchException;

public class Student extends Person{
    Boolean isInternational = false;
    int enrollmentNumber;
    protected final LocalDate dateOfEnrollment;

    public Student(String firstName, String lastName, LocalDate birthDate, long phoneNumber, String email,
                   Boolean isInternational, int enrollmentNumber, LocalDate dateOfEnrollment) throws InputMismatchException {
        super(firstName, lastName, birthDate, phoneNumber, email);
        this.isInternational = isInternational;
        this.enrollmentNumber = enrollmentNumber;
        this.dateOfEnrollment = dateOfEnrollment;


    }

    @Override
    public String toString() {
        return "Name: "+firstName+" "+lastName+"\n" +
                "Birthdate: "+birthDate+"\n" +
                "Enrollment Number: "+enrollmentNumber+"\n" +
                "International: "+isInternational+"\n" +
                "Phone number: "+phoneNumber+"\n" +
                "Email: "+email+"\n" +
                "date of Enrollment: "+ dateOfEnrollment+"\n";
    }
}
