import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
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

                if (p.getClass() == Student.class){
                    displayView(persons, currentUser);

                } else if (p.getClass() == Teacher.class) {

                    displayView(persons, currentUser);

                } else{ return; }
            }
        }
        System.out.println("Program closed.");
    }

    private static void initialise(List<Person> persons){
        persons.add(new Student("Mirko", "Cuccurullo", 1, LocalDate.now(),"IT2A" , "mirko123", "1234"));
        persons.add(new Teacher("Jack", "Sparrow", 2, LocalDate.now(), 3000, "jack123", "1234"));
    }

    private static void displayView(List<Person> persons, Person currentUser){
        while (true){
            Scanner scanner = new Scanner(System.in);
            if (currentUser.getClass() == Student.class) {
                System.out.println("S. Display Students   |   T. Display Teachers   |  X. Exit   |");
            }
            else{
                System.out.println("S. Display Students   |   T. Display Teachers   |   A. Add Students   |   R. Display Report   |  X. Exit   |");
            }
            System.out.print("Please, enter a choice: ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("S")) {
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

            } else if (choice.equalsIgnoreCase("T")) {

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
            } else if (choice.equalsIgnoreCase("A") && currentUser.getClass() != Student.class) {

                System.out.println("ADD STUDENT");
                System.out.println();
                System.out.println("choose a username: ");
                String username = scanner.next();
                System.out.println("choose a password: ");
                String password = scanner.next();
                System.out.println("Enter first name: ");
                String firstName = scanner.next();
                System.out.println("Enter last name: ");
                String lastName = scanner.next();
                System.out.println("please enter date of birth in (MM/DD/YY): ");
                String birthDate = scanner.next();
                System.out.println("Enter group: ");
                String group = scanner.next();

                persons.add(new Student(firstName,lastName, persons.size()+1, LocalDate.now(), group, username,password));

                System.out.println("The data was successfully added!");
            } else if (choice.equalsIgnoreCase("x")) {
                return;
            }
            else{
                System.out.println("something went wrong...");
            }
        }
    }
}