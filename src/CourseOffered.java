import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;

public class CourseOffered {
    private static CourseOffered courseOffered = null;
    static public ArrayList<Course> allCourse;
    private CourseOffered(){
        allCourse = new ArrayList<>();
    }


    public static void addCourse(Course course) throws DuplicateRequestException{
        if(courseOffered == null) {
            courseOffered = new CourseOffered();
        }
        if(allCourse.contains(course)){
                throw new DuplicateRequestException("course already exits!!");
        }
        allCourse.add(course);
    }

    public static void listCourses() throws NullPointerException {
        if (courseOffered == null) {
            courseOffered = new CourseOffered();
            throw new NullPointerException("No professors in the list!!!");
        } else if (allCourse.isEmpty()) {
            throw new NullPointerException("No professors in the list!!!");
        } else {
            int i = 1;
            for (Course course : allCourse) {
                System.out.println("" + i + ". CourseID: " + course.courseId + ", CourseName" + course.courseName+", Credits: "+course.credits);
                i++;
            }
        }
    }
}
