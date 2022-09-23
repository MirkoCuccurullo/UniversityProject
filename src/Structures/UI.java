package Structures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    public static void displayView(List<Person> persons, Person currentUser){

        Scanner scanner = new Scanner(System.in);
        Database db = Database.getInstance();

        while (true){
            displayMainMenu(currentUser);

            System.out.print("Please, enter a choice: ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("S")) {

                displayStudents(currentUser);

            } else if (choice.equalsIgnoreCase("T")) {

                displayListOfTeacher(currentUser);

            } else if (choice.equalsIgnoreCase("A") && currentUser.getClass() != Student.class) {

                displayAddStudent(persons);

            } else if (choice.equalsIgnoreCase("R") && currentUser.getClass() != Student.class) {

                displayReportView(db.getPersons(), currentUser);

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
        System.out.println("Structures.Student ID .............. " + student.getID());
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
    }
    private static void displayAddStudent(List<Person> persons) {
        try {
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
            String dateString = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(dateString, dateTimeFormatter);

            System.out.print("Enter group: ");
            String group = scanner.next();

            persons.add(new Student(firstName, lastName, persons.size() + 1, birthDate, group, username, password));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("The data was successfully added!");


    }

    private static void displayListOfTeacher(Person currentUser){

        Scanner scanner = new Scanner(System.in);
        Database db = Database.getInstance();
        List<Teacher> teachers = db.returnTeacherList();

        System.out.println("LIST OF TEACHERS");
        System.out.println();
        System.out.println("ID:       First Name:       Last Name:       Birthday:       Age:       ");
        System.out.println("**        ***** *****       **** *****       *********       ****       ");

        for (Teacher t : teachers) {

            System.out.println(t);

        }
        System.out.println();

        if (currentUser.getClass() == Manager.class){

            managerFunctionforTeacher();
        }

    }

    private static void managerFunctionforTeacher(){

        Scanner scanner = new Scanner(System.in);
        Database db = Database.getInstance();

        System.out.print("1.ADD TEACHER   |   2.DELETE TEACHER   | 3.BACK");
        System.out.println();
        System.out.println("insert menu number: ");
        int answer = scanner.nextInt();

        switch (answer){
            case 1:
                addTeacher();
                break;
            case 2:
                System.out.print("Insert ID: ");
                int idToDelete = scanner.nextInt();
                db.deleteByID(idToDelete);
                break;
            case 3:
                return;
            default: break;
        }
    }

    private static void addTeacher(){
        try {
            Scanner scanner = new Scanner(System.in);
            Database db = Database.getInstance();
            List<Person> personList = db.getPersons();
            System.out.println("ADD TEACHER");
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
            String dateString = scanner.next();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(dateString, dateTimeFormatter);


            System.out.print("Enter salary: ");
            int salary = scanner.nextInt();

            personList.add(new Teacher(firstName, lastName, personList.size() + 1, birthDate, salary, username, password));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("The data was successfully added!");
    }

    private static void displayMainMenu(Person currentUser){

        if (currentUser.getClass() == Student.class) {
            System.out.println("S. Display Students   |   T. Display Teachers   |  X. Exit   |");
        }
        else{
            System.out.println("S. Display Students   |   T. Display Teachers   |   A. Add Students   |   R. Display Report   |  X. Exit   |");
        }

    }
    private static void displayStudents(Person currentUser){

        Database db = Database.getInstance();
        List<Student> students = db.returnStudentsList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("LIST OF STUDENTS");
        System.out.println();
        System.out.println("ID:       First Name:       Last Name:       Birthday:       Age:       Group:       ");
        System.out.println("**        ***** *****       **** *****       *********       ****       ******");

        for (Student s : students){
            System.out.println(s);
        }
        System.out.println();

        if (currentUser.getClass() == Manager.class){

            System.out.print("delete student? (y/n)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("y")){
                System.out.print("Insert ID: ");
                int idToDelete = scanner.nextInt();
                db.deleteByID(idToDelete);
            }
        }
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

    }

    private static void selectionOfMenu(String selection, Student student, List<Person> persons, Person currentUser){

        Scanner scanner = new Scanner(System.in);
        Database db = Database.getInstance();
        if (selection.equalsIgnoreCase("a")) {

            addGradesToReport(student);
            System.out.print("please enter a choice, select a menu: ");
            String newSelection = scanner.next();
            selectionOfMenu(newSelection, student,db.getPersons(), currentUser);

        } else if (selection.equalsIgnoreCase("r")) {
            displayReportView(db.getPersons(), currentUser);
        } else if (selection.equalsIgnoreCase("b")) {
            displayView(db.getPersons(),currentUser);

        } else if (selection.equalsIgnoreCase("x")) {

        } else {
            System.out.println("something went wrong");
        }

        scanner.close();
    }
}
