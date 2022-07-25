import com.sun.jdi.request.DuplicateRequestException;

import java.io.InvalidClassException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Input {
    public void mainMenu(Scanner sc) throws InputMismatchException {
        System.out.println("####################################################################");
        System.out.println("""
                Enter 1 for Student,
                Enter 2 for Professor,
                Enter 3 for Admin,
                Enter 4 to Exit.
                """);
        System.out.println("####################################################################");
        int mainOption = 0;
        try {
            mainOption = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Enter Valid option!!!");
            mainMenu(sc);
        }
        if (mainOption == 4) {
            System.exit(0);
        } else if (mainOption == 1) {
            Student current = null;
            try {
                studentInput(sc, current);
                throw new InputMismatchException("Enter Valid Options");
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
                studentInput(sc, current);
            }
        } else if (mainOption == 2) {
            Professor current = null;
            try {
                professorInput(sc, current);
                throw new InputMismatchException("Enter Valid Options");
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
                professorInput(sc, current);
            }
        } else if (mainOption == 3) {
            adminMenu(sc, 0);
        } else {
            System.err.println("Enter Valid Options");
            mainMenu(sc);
        }
    }

    private void adminMenu(Scanner sc, int count) {
        String username;
        String password;
        Admin admin;
        int adminOptions;
        System.out.println("""
                Enter 1 to Login,
                Enter 2 to Go back,
                Enter 3 to Exit.
                """);
        try {
            if (count == 4) {
                System.err.println("Multiple Failed Attempts.. BYE BYE!!!");
                System.exit(1);
            } else {
                try {
                    adminOptions = sc.nextInt();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid options");
                }
                if (adminOptions == 1) {
                    try {
                        System.out.print("Enter Username: ");
                        username = sc.next();
                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Enter Valid Input");
                    }
                    try {
                        System.out.print("Enter Password: ");
                        password = sc.next();
                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Enter Valid Input");
                    }
                    admin = Admin.loginAdmin(username, password);

                    if (admin != null) {
                        System.out.println("Welcome!!");
                        adminInput(sc, admin);
                        adminMenu(sc, 0);
                    } else {
                        adminMenu(sc, count + 1);
                    }
                } else if (adminOptions == 2) {
                    mainMenu(sc);
                }else if(adminOptions ==3){
                    System.out.println("BYE BYE!!");
                    System.exit(1);
                }else{
                    System.err.println("Enter valid options");
                    adminMenu(sc,0);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            adminMenu(sc, count);
        }
    }

    private void adminInput(Scanner sc, Admin admin) {
        int options;
        System.out.println("""
                Enter 1 to add Course,
                Enter 2 to add Professor,
                Enter 3 to list Courses,
                Enter 4 to list Professors,
                Enter 5 to Go back,
                Enter 6 to exit.
                """);

        try {
            try {
                options = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter from Valid Options");
            }
            if (options == 1) {
                String courseName;
                int courseId;
                int credits;
                try {
                    try {
                        System.out.print("Enter the Course Name: ");
                        courseName = sc.next();
                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Enter Valid name!!");
                    }
                    try {
                        System.out.print("Enter Course id ");
                        courseId = sc.nextInt();
                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Enter Valid id!!");
                    }
                    try {
                        System.out.print("Enter the course Credits ");
                        credits = sc.nextInt();
                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Enter Valid Credits!!");
                    }
                    Course x = new Course(courseId, courseName, credits);
                    CourseOffered.addCourse(x);
                    CourseOffered.listCourses();
                    System.err.println("##################");
                    adminInput(sc, admin);
                } catch (Exception e) {
                    throw e;
                }
            } else if (options == 2) {
                String firstName;
                String lastName;
                long phoneNumber;
                String email;
                String position;
                Professor professor;
                try {
                    System.out.print("Enter the First Name: ");
                    firstName = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid name!!");
                }
                try {
                    System.out.print("Enter the Last Name: ");
                    lastName = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid name!!");
                }
                try {
                    System.out.print("Enter the Phone Number: ");
                    phoneNumber = sc.nextLong();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Number!!");
                }

                try {
                    System.out.print("Enter the email: ");
                    email = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid email!!");
                }

                try {
                    System.out.print("What is the position? ");
                    position = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid entry!!");
                }
                Random r = new Random();
                int empNo = Math.abs(r.nextInt() * 100);
                try {
                    if (firstName == null || lastName == null || phoneNumber == 0 || email == null || position == null) {
                        throw new NullPointerException("Not valid Details!!");
                    } else {
                        professor = new Professor(firstName, lastName, LocalDate.now(), phoneNumber, email, position, empNo, new ArrayList<>());
                        try {
                            professorList.addProfessor(professor);
                            System.out.println("Professor added to list");
                            adminInput(sc, admin);
                        } catch (DuplicateRequestException e) {
                            throw e;
                        }
                    }
                } catch (Exception e) {
                    throw new Exception("Cant Create object");
                }
            } else if (options == 4) {
                try {
                    professorList.listProfessors();
                    adminInput(sc, admin);
                } catch (NullPointerException e) {
                    throw e;
                }
            } else if (options == 3) {
                try {
                    CourseOffered.listCourses();
                    adminInput(sc, admin);
                } catch (NullPointerException e) {
                    throw e;
                }
            } else if (options == 5) {
                adminMenu(sc, 0);
            } else if (options == 6) {
                System.out.println("BYE BYE!!!");
                System.exit(0);
            } else {
                System.out.println("Enter valid options");
                adminInput(sc, admin);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            adminInput(sc, admin);
        }
    }

    public void studentInput(Scanner sc, Student current) throws InputMismatchException {
        System.err.println("#########################################################");
        System.out.println("""
                Enter 1 to Register,
                Enter 2 to see your details,
                Enter 3 to enroll in Course,
                Enter 4 to check grades,
                Enter 5 to exit.
                """);
        System.err.println("#########################################################");
        int whatToDo = sc.nextInt();

        if (whatToDo == 1) {
            current = studentDetails(sc);
            System.err.println("#########################################################");
            if (current != null) {
                System.err.println("               Registered                  ");
            } else {
                System.err.println("            Fail to register               ");
            }
            System.err.println("#########################################################");
            studentInput(sc, current);
        }
        if (whatToDo == 2) {
            try {
                if (current == null) {
                    throw new NullPointerException("You are not registered yet!! please Register first");
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                studentInput(sc, current);
            }
            assert current != null;
            System.err.println(current);
            try {
                TimeUnit.SECONDS.sleep(3);
                throw new InterruptedException("Stopped");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                studentInput(sc, current);
            }
        } else if (whatToDo == 3) {
            try {
                try {
                    if (current == null) {
                        throw new NullPointerException("You are not registered yet!! please Register first");
                    }
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    studentInput(sc, current);
                }
                try {
                    System.out.println("Enter the course id");
                    int id = sc.nextInt();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("enter valid course id");
                }
                try {
                    System.out.println("Enter the course name");
                    String courseName = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("enter valid course name");
                }
                try {
                    System.out.println("Enter the course id");
                    int id = sc.nextInt();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("enter valid course id");
                }
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
                studentInput(sc, current);
            }
        } else if (whatToDo == 5) {
            System.out.println("THANK YOU FOR USING!!!");
            System.exit(0);
        } else {
            System.err.println("Enter Valid Option!!!");
            studentInput(sc, current);
        }
    }

    public Student studentDetails(Scanner sc) {
        Student current = null;
        String firstName;
        String lastName;
        long phoneNumber;
        String email;
        String inl;
        try {
            try {
                System.out.print("Enter your First Name: ");
                firstName = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid name!!");
            }
            try {
                System.out.print("Enter your Last Name: ");
                lastName = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid name!!");
            }
            try {
                System.out.print("Enter your Phone Number: ");
                phoneNumber = sc.nextLong();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Number!!");
            }

            try {
                System.out.print("Enter your email: ");
                email = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid email!!");
            }

            try {
                System.out.print("Are you International Student? Enter Yes/No ");
                inl = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid entry!!");
            }
            boolean intl;
            Random r = new Random();
            int enrNo = Math.abs(r.nextInt() * 100);
            assert inl != null;
            intl = inl.equalsIgnoreCase("yes");
            try {
                if (firstName == null || lastName == null || phoneNumber == 0 || email == null) {
                    throw new NullPointerException("Not valid Details!!");
                } else {
                    current = new Student(firstName, lastName, LocalDate.now(), phoneNumber, email, intl, enrNo, LocalDate.now());
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("Cant Create object");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            studentDetails(sc);
        }
        return current;
    }


    public void professorInput(Scanner sc, Professor current) {
        System.err.println("#########################################################");
        System.out.println("""
                Enter 1 to Register,
                 Enter 2 to see your details,
                 Enter 3 to check Grades of Student,
                 Enter 4 to add Course,
                 Enter 5 to promote the position(Dean Only),
                 Enter 6 to exit""");
        System.err.println("#########################################################");
        int whatToDo = sc.nextInt();

        if (whatToDo == 1) {
            current = professorDetails(sc, current);
            System.err.println("#########################################################");
            if (current != null) {
                System.err.println("         Registered         ");
            } else {
                System.err.println("      Fail to register      ");
            }
            System.err.println("#########################################################");
            professorInput(sc, current);
        } else if (whatToDo == 2) {
            try {
                if (current == null) {
                    throw new NullPointerException("You are not registered yet!! please Register first");
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                professorInput(sc, current);
            }
            assert current != null;
            System.err.println(current);
            try {
                TimeUnit.SECONDS.sleep(3);
                throw new InterruptedException("Stopped");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                professorInput(sc, current);
            }
        } else if (whatToDo == 4) {
            try {
                if (current == null) {
                    throw new NullPointerException("You are not registered yet!! please Register first");
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                professorInput(sc, current);
            }

            String courseName;
            int courseId;
            int credits;
            try {
                try {
                    System.out.print("Enter the Course Name: ");
                    courseName = sc.next();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid name!!");
                }
                try {
                    System.out.print("Enter Course id ");
                    courseId = sc.nextInt();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid id!!");
                }
                try {
                    System.out.print("Enter the course Credits ");
                    credits = sc.nextInt();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Enter Valid Credits!!");
                }
                try {
                    assert current != null;
                    Course x = new Course(courseId, courseName, credits, current);
                    current.addCourse(x);
                    professorInput(sc, current);
                } catch (InvalidClassException e) {
                    throw new InvalidClassException("Can't Register try Again!!!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                professorDetails(sc, current);
            }

        } else if (whatToDo == 6) {
            System.out.println("THANK YOU FOR USING!!!");
            System.exit(0);

        } else {
            System.err.println("Enter Valid Option!!!");
            professorInput(sc, current);
        }
    }

    public Professor professorDetails(Scanner sc, Professor current) {
        String firstName;
        String lastName;
        long phoneNumber;
        String email;
        String position;
        try {
            try {
                System.out.print("Enter your First Name: ");
                firstName = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid name!!");
            }
            try {
                System.out.print("Enter your Last Name: ");
                lastName = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid name!!");
            }
            try {
                System.out.print("Enter your Phone Number: ");
                phoneNumber = sc.nextLong();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Number!!");
            }

            try {
                System.out.print("Enter your email: ");
                email = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid email!!");
            }

            try {
                System.out.print("What is your position? ");
                position = sc.next();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Enter Valid entry!!");
            }
            Random r = new Random();
            int empNo = Math.abs(r.nextInt() * 100);
            try {
                if (firstName == null || lastName == null || phoneNumber == 0 || email == null || position == null) {
                    throw new NullPointerException("Not valid Details!!");
                } else {
                    current = new Professor(firstName, lastName, LocalDate.now(), phoneNumber, email, position, empNo, new ArrayList<>());
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("Cant Create object");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            professorDetails(sc, current);
        }
        return current;
    }
}
