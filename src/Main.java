
import java.io.InvalidClassException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidClassException {
        Professor Tony = new Professor("Tony","Stark", LocalDate.ofEpochDay(1989- 1 -11),7898748787L,
                "tonystark@gmail.com","Dean",001,
                new ArrayList<>());
        Professor Kevin = new Professor("Kevin","Max", LocalDate.ofEpochDay(1995- 1 -18),98748412217L,
                "KevinMax@gmail.com","Assistant Professor",002,new ArrayList<>());


        System.out.println("############################################################################################");
        System.out.println(Tony.firstName);
        System.out.println(Kevin.position);
        System.out.println(Tony.changePosition(false,Kevin,"Lecturer"));
        System.out.println(Kevin.position);
        System.out.println("############################################################################################");
        System.out.println("");


        Student Kishan = new Student("Kishan","Modi" ,LocalDate.ofEpochDay(2000-11-16),
                7016388641L,"kishandmodi@gmail.com",true,
                1611, LocalDate.now());

        Course CS101 = new Course(101,"CS101",Tony,Kishan, 3);
        System.out.println("############################################################################################");
        System.out.println(Tony.toString());
        System.out.println("############################################################################################");
        System.out.println(Kevin.toString());
        System.out.println("############################################################################################");
        System.out.println(Kishan.toString());
        System.out.println("############################################################################################");
        System.out.println(CS101.toString());
        System.out.println("############################################################################################");
        System.out.println(Tony.toString());
        System.out.println("############################################################################################");
        System.out.println(Kishan.toString());
        System.out.println("############################################################################################");


    }
}
