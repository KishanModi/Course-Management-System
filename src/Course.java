import java.io.InvalidClassException;
import java.util.ArrayList;

public class Course {
    final int courseId;
    final String courseName;
    final int credits;
    ArrayList<Professor> instructors;
    ArrayList<Student> students;

    public Course(int courseId, String courseName, Professor instructor, int credits) throws InvalidClassException {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        instructor.addCourse(this);
        try {
            if (!(instructor instanceof Professor)) {
                throw new InvalidClassException("Invalid Entry");
            }
        } catch (NullPointerException | InvalidClassException e) {
            System.out.println(e.getMessage());
        }
        this.instructors.add(instructor);
    }

    public Course(int courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public Course(int courseId, String courseName, int credits, Professor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.instructors = new ArrayList<>();
        try {
            if (!(instructor instanceof Professor)) {
                throw new InvalidClassException("Invalid Professor");
            }
        } catch (NullPointerException | InvalidClassException e) {
            System.out.println(e.getMessage());
        }
        instructors.add(instructor);

    }

    public void addProfessor(Professor professor) throws NullPointerException {
        try {
            if (professor == null) {
                throw new NullPointerException("Invalid Entry");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.instructors.add(professor);
    }

    public void addStudent(Course course, Student student) {
        if(course==null || student == null){
            System.err.println("Enter Valid Details");
        }
        this.students.add(student);
    }
}
