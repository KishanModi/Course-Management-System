import com.sun.jdi.request.DuplicateRequestException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Admin extends Person{
    static Admin admin = null;
    private final String username="kishan";
    private final String password="123456";

    private Admin() {
        super("Kishan", "Modi", LocalDate.now(),
                69696969,"kishandmodi@gmail.com");
    }


    public static Admin loginAdmin(String username,String password) throws NullPointerException{
        if(username==null || password==null){
            throw new NullPointerException("Details can't be null");
        }
        if(admin==null){
            admin = new Admin();
        }
        if(admin.username.equals(username) && admin.password.equals(password)){
            return admin;
        }
        else{

            System.err.println("Invalid Details");
            return null;
        }
    }
    public void addCourse(Course course){
        if(course==null){
            System.err.println("Course can not be null");
            return;
        }
        try{
            CourseOffered.addCourse(course);
        }catch(DuplicateRequestException e){
            System.err.println(e.getMessage());
        }
    }
    public void listCourses(){
        CourseOffered.listCourses();
    }
    public void addProfessor(Professor professor){
        if(professor==null){
            System.err.println("Professor can not be null");
            return;
        }
        try{
            professorList.addProfessor(professor);
        }catch(DuplicateRequestException e){
            System.err.println(e.getMessage());
        }
    }

    public void listProfessors(){
        professorList.listProfessors();
    }
}
