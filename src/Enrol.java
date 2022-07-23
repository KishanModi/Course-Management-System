import java.io.InvalidClassException;
import java.time.LocalDate; // import the LocalDate class


public class Enrol {
    int grade;
    LocalDate enrolDate;
    Course course;
    Student student;
    Professor professor;

    public Enrol(int grade, Course course, Student student, Professor professor) {
        this.grade = grade;
        this.enrolDate = LocalDate.now();
        this.course = course;
        this.student = student;
        this.professor = professor;
    }

    public int checkGrades(Student student, Course course) throws NullPointerException {
        try {
            if (course == null || student == null) {
                throw new NullPointerException("Invalid Entries");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return this.grade;
    }

    public int checkGrades(Professor professor, Course course, Student student) throws NullPointerException {
        try {
            if (!(professor instanceof Professor)) {
                throw new InvalidClassException("Invalid Entry");
            } else if (professor == null || course == null || student == null) {
                throw new NullPointerException("Invalid Entries");
            }
        } catch (NullPointerException | InvalidClassException e) {
            System.out.println(e.getMessage());
        }
        return this.grade;
    }
}
