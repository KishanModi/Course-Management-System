import java.io.InvalidClassException;
import java.util.ArrayList;

public class Course {
    final int courseId;
    final String courseName;
    ArrayList<Professor> instructors;
    ArrayList<Student> students;
    final int credits;

    public Course(int courseId, String courseName, ArrayList<Professor> instructors,
                  ArrayList<Student> students, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructors = instructors;
        this.students = students;
        this.credits = credits;
    }
    public Course(int courseId, String courseName, Professor instructor,
                  Student student, int credits) throws InvalidClassException {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        if(students==null){
            students = new ArrayList<>();
        }
        if(instructors==null){
            instructors = new ArrayList<>();
        }
        instructor.addCourse(this);
        try{
            if(!(student instanceof Student) || !(instructor instanceof Professor)){
                throw new InvalidClassException("Invalid Entry");
            }else if(student == null || instructor == null){
                throw new NullPointerException("Invalid Entry");
            }
        }catch(NullPointerException | InvalidClassException e){
            System.out.println(e.getMessage());
        }
        this.instructors.add(instructor);
        this.students.add(student);
    }
    public void addProfessor(Professor professor) throws NullPointerException{
        try{
            if(professor==null){
                throw new NullPointerException("Invalid Entry");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.instructors.add(professor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", instructors=" + instructors +
                ", students=" + students +
                ", credits=" + credits +
                '}';
    }
}
