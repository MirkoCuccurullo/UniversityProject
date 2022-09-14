import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        initialise(persons);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (Person p : persons){
            if (username.equals(p.getUsername()) && password.equals(p.getPassword())){

                if (p.getClass() == Student.class){
                    displayStudentView(persons);

                } else if (p.getClass() == Teacher.class) {

                    System.out.println("Not yet implemented");

                } else{ return; }
            }
        }
        System.out.println("Program closed.");
    }

    private static void initialise(List<Person> persons){
        persons.add(new Student("Mirko", "Cuccurullo", 1, LocalDate.now(), 25, "IT2A" , "mirko123", "1234"));
        persons.add(new Teacher("Jack", "Sparrow", 1, LocalDate.now(), 35, 3000, "jack123", "1234"));
    }

    private static void displayStudentView(List<Person> persons){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("S. Display Students   |   T. Display Teachers   |  X. Exit   |");
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
            } else if (choice.equalsIgnoreCase("x")) {
                return;
            }
        }
    }
}