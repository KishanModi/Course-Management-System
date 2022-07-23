import java.io.InvalidClassException;
import java.util.ArrayList;
import java.time.LocalDate; // import the LocalDate class

public class Professor extends Person{
    String position;
    final private int employeeNumber;
    ArrayList<Course> courses;

    public Professor(String firstName, String lastName, LocalDate birthDate, long phoneNumber, String email,
                     String position, int employeeNumber, Course course) {
        super(firstName, lastName, birthDate, phoneNumber, email);
        this.position = position;
        this.employeeNumber = employeeNumber;
        this.courses = new ArrayList<Course>();
        this.courses.add(course);
    }

    public Professor(String firstName, String lastName, LocalDate  birthDate, long phoneNumber, String email,
                     String position, int employeeNumber, ArrayList<Course> courses) {
        super(firstName, lastName, birthDate, phoneNumber, email);
        this.position = position;
        this.employeeNumber = employeeNumber;
        this.courses = courses;
    }

    public Boolean addCourse(Course course) throws InvalidClassException,NullPointerException{
        try{
            if(course==null){
                throw new NullPointerException("Course is invalid");
            }
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }
        this.courses.add(course);
        return true;
    }
    public String changePosition(Boolean promote, Professor professor, String position) throws NullPointerException{
        try{
            if(!this.position.equalsIgnoreCase("Dean")){
                throw new CustomException("You are not allowed!!");
            }
            else if(professor==null || position==null){
                throw new NullPointerException("Invalid Input");
            }
        }catch(CustomException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        professor.position = position;
        return promote ? "Promoted":"Demoted";

    }

//    @Override
//    public String toString() {
//        return "Professor{" +
//                "position='" + position + '\'' +
//                ", employeeNumber=" + employeeNumber +
//                ", courses=" + courses +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", birthDate=" + birthDate +
//                ", phoneNumber=" + phoneNumber +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
