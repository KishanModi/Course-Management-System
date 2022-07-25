import com.sun.jdi.request.DuplicateRequestException;

import java.util.ArrayList;

public class professorList {

    static professorList professorList = null;
    ArrayList<Professor> allProfessors = new ArrayList<>();

    private professorList() {
        allProfessors = new ArrayList<>();
    }

    public static void addProfessor(Professor professor) throws DuplicateRequestException {
        if (professorList == null) {
            professorList = new professorList();
        }
        if (professorList.allProfessors.contains(professor)) {
            throw new DuplicateRequestException("Professor Already Exits");
        }
        professorList.allProfessors.add(professor);
    }

    public static void listProfessors() throws NullPointerException {
        if (professorList == null) {
            professorList = new professorList();
            throw new NullPointerException("No professors in the list!!!");
        } else if (professorList.allProfessors.isEmpty()) {
            throw new NullPointerException("No professors in the list!!!");
        } else {
            int i = 0;
            for (Professor professor : professorList.allProfessors) {
                System.out.println("" + i + ". " + professor.firstName + " " + professor.lastName);
                i++;
            }
        }
    }
}
