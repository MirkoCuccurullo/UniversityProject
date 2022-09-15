import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        Person currentUser;

        initialise(persons);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (Person p : persons){
            if (username.equals(p.getUsername()) && password.equals(p.getPassword())){

                currentUser = p;
                displayView(persons,currentUser);

            }
        }
        scanner.close();
        System.out.println("Program closed.");
    }

    private static void initialise(List<Person> persons){
        persons.add(new Student("Mirko", "Cuccurullo", 1, "10/05/1997","IT2A" , "mirko123", "1234"));
        persons.add(new Teacher("Jack", "Sparrow", 2, "10/05/1987", 3000, "jack123", "1234"));
    }

    private static void displayView(List<Person> persons, Person currentUser){

        Scanner scanner = new Scanner(System.in);

        while (true){
            displayMainMenu(currentUser);

            System.out.print("Please, enter a choice: ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("S")) {

                displayStudentsForStudents(persons);

            } else if (choice.equalsIgnoreCase("T")) {

                displayListOfTeacherForStudents(persons);

            } else if (choice.equalsIgnoreCase("A") && currentUser.getClass() != Student.class) {

                displayAddStudent(persons);

            } else if (choice.equalsIgnoreCase("R") && currentUser.getClass() != Student.class) {

               displayReportView(persons, currentUser);

            } else if (choice.equalsIgnoreCase("x")) {
                break;
            }
            else{

                System.out.println("something went wrong...");
            }
        }
        scanner.close();
    }
    private static void displayStudentsReport(List<Person> persons, List<Student> students){

        System.out.println("STUDENTS RESULTS");
        System.out.println();
        System.out.println("ID:       First Name:       Last Name:       Birthday:       Age:       Group:       Java:      CSharp:      Python:      PHP:");
        System.out.println("**        ***** *****       **** *****       *********       ****       ******       *****      *******      *******      ****");

        for (Person p : persons){

            if (p.getClass() == Student.class) {
                Student student = (Student)p;
                students.add(student);
                System.out.println(student.toStringWithGrades());
            }
        }
        System.out.println();
    }
    private static void printSingleStudentReport(Student student){

        System.out.println("Report of student" + student.getFirstName() + " " + student.getLastName());
        System.out.println();
        System.out.println("Student ID .............. " + student.getID());
        System.out.println("First Name .............. " + student.getFirstName());
        System.out.println("Last Name .............. " + student.getLastName());
        System.out.println("Age .............. " + student.getAge());
        System.out.println();
        System.out.println("COURSES");
        System.out.println();
        System.out.println("Java .............. " + student.getGrade("Java"));
        System.out.println("CSharp .............. " + student.getGrade("CSharp"));
        System.out.println("Python .............. " + student.getGrade("Python"));
        System.out.println("PHP .............. " + student.getGrade("PHP"));
        System.out.println();
        System.out.println("RESULTS");
        System.out.println();
        System.out.println("Result .............. " + student.getHasPassedAsString());
        System.out.println("Retakes .............. " + student.getNumberOfRetakes());
        System.out.println();
    }
    private static void displayReportView(List<Person> persons, Person currentUser) {

        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        displayStudentsReport(persons, students);

        System.out.print("Enter student id (Report Details) | or 0 back to main menu: ");
        int action = scanner.nextInt();
        System.out.println();

        if (action > 0) {
            for (Student student : students) {
                if (student.getID() == action) {

                    printSingleStudentReport(student);

                    System.out.println("A. Add (Update) Report   |   R. Display Reports   |   B. Back to main   |  X. Exit   |");
                    System.out.print("please enter a choice, select a menu: ");
                    String selection = scanner.next();

                    selectionOfMenu(selection, student,persons, currentUser);

                } else {
                    System.out.println("No student with this ID...");
                }
            }
        }
        scanner.close();
    }
    private static void displayAddStudent(List<Person> persons){

        Scanner scanner = new Scanner(System.in);
        System.out.println("ADD STUDENT");
        System.out.println();
        System.out.print("choose a username: ");
        String username = scanner.next();
        System.out.print("choose a password: ");
        String password = scanner.next();
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("please enter date of birth in (DD/MM/YY): ");
        String birthDate = scanner.next();
        System.out.print("Enter group: ");
        String group = scanner.next();

        persons.add(new Student(firstName, lastName, persons.size() + 1, birthDate, group, username, password));

        System.out.println("The data was successfully added!");

        scanner.close();
    }

    private static void displayListOfTeacherForStudents(List<Person> persons){

        System.out.println("LIST OF TEACHERS");
        System.out.println();
        System.out.println("ID:       First Name:       Last Name:       Birthday:       Age:       ");
        System.out.println("**        ***** *****       **** *****       *********       ****       ");

        for (Person p : persons){
            if (p.getClass() == Teacher.class) {
                Teacher teacher = (Teacher) p;
                System.out.println(teacher);
            }
        }
        System.out.println();
    }

    private static void displayMainMenu(Person currentUser){

        if (currentUser.getClass() == Student.class) {
            System.out.println("S. Display Students   |   T. Display Teachers   |  X. Exit   |");
        }
        else{
            System.out.println("S. Display Students   |   T. Display Teachers   |   A. Add Students   |   R. Display Report   |  X. Exit   |");
        }

    }
    private static void displayStudentsForStudents(List<Person> persons){

        System.out.println("LIST OF STUDENTS");
        System.out.println();
        System.out.println("ID:       First Name:       Last Name:       Birthday:       Age:       Group:       ");
        System.out.println("**        ***** *****       **** *****       *********       ****       ******");

        for (Person p : persons){
            if (p.getClass() == Student.class) {
                Student student = (Student)p;
                System.out.println(student);
            }
        }
        System.out.println();
    }
    private static void addGradesToReport(Student student){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Current grade Java is " + student.getGrade("Java") +
                " Enter (new) grade: ");
        int newJavaGrade = scanner.nextInt();
        student.setGrade(newJavaGrade, "Java");
        System.out.print("Current grade CSharp is " + student.getGrade("CSharp") +
                " Enter (new) grade: ");
        int newCSharpGrade = scanner.nextInt();
        student.setGrade(newCSharpGrade, "CSharp");
        System.out.print("Current grade Python is " + student.getGrade("Python") +
                " Enter (new) grade: ");
        int newPythonGrade = scanner.nextInt();
        student.setGrade(newPythonGrade, "Python");
        System.out.print("Current grade PHP is " + student.getGrade("PHP") +
                " Enter (new) grade: ");
        int newPHPGrade = scanner.nextInt();
        student.setGrade(newPHPGrade, "PHP");

        scanner.close();
    }

    private static void selectionOfMenu(String selection, Student student, List<Person> persons, Person currentUser){

        Scanner scanner = new Scanner(System.in);
        if (selection.equalsIgnoreCase("a")) {

            addGradesToReport(student);
            System.out.print("please enter a choice, select a menu: ");
            String newSelection = scanner.next();
            selectionOfMenu(newSelection, student,persons, currentUser);

        } else if (selection.equalsIgnoreCase("r")) {
            displayReportView(persons, currentUser);
        } else if (selection.equalsIgnoreCase("b")) {
            displayView(persons,currentUser);

        } else if (selection.equalsIgnoreCase("x")) {

        } else {
            System.out.println("something went wrong");
        }

        scanner.close();
    }

}