import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Input i = new Input();
            do{
                try {
                    i.mainMenu(sc);
                    throw new InputMismatchException("Enter the valid options!!!");
                } catch (InputMismatchException e) {
                    System.err.println(e.getMessage());
                }

            }while(true);
    }
}
