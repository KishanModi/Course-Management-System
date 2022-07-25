import java.time.LocalDate;
import java.util.InputMismatchException;

public class Person {
    String firstName;
    String lastName;
    final LocalDate birthDate;
    long phoneNumber;
    String email;

    public Person(String firstName, String lastName,LocalDate birthDate, long phoneNumber, String email) throws InputMismatchException {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.phoneNumber = phoneNumber;
            this.email = email;
    }

    public void updatePhoneNumber(long phoneNumber) throws CustomException{
        try{
            int len = String.valueOf(phoneNumber).length();
            if(len<12 && len>5) {
                throw new CustomException("Invalid Phone number!!");
            }
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }
        this.phoneNumber = phoneNumber;
    }

    public void updateEmail(String email) throws CustomException,NullPointerException{
        try{
            if(email==null){
                throw new NullPointerException("Email can't be empty");
            }
            else if(!email.matches("^[a-zA-Z\\d+_.-]+@[a-zA-Z\\d.-]+$")) {
                throw new CustomException("Invalid email!!");
            }
        }catch(NullPointerException | CustomException n){
            System.out.println(n.getMessage());
        }
        this.email = email;
    }

    public void setFirstName(String firstName) throws NullPointerException {
        try{
            if(firstName==null) {
                throw new NullPointerException("First name can't be empty");
            }
        }catch(NullPointerException n){
            System.out.println(n.getMessage());
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws NullPointerException {
        try{
            if(lastName==null) {
                throw new NullPointerException("Last name can't be empty");
            }
        }catch(NullPointerException n){
            System.out.println(n.getMessage());
        }
        this.lastName = lastName;
    }
}
