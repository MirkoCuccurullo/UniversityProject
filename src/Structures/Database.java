package Structures;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Database {

    private static List<Person> persons = null;
    private static Database db;

    private Database(){
        persons = new ArrayList<>();
        initialise(persons);
    }

    public static Database getInstance(){
        if (persons == null){
            db = new Database();
            return db;

        }
        else {return db;}
    }

    public List<Person> getPersons(){
        return persons;
    }

    private static void initialise(List<Person> persons){
        persons.add(new Student("Mirko", "Cuccurullo", 1, LocalDate.of(1997,05,10),"IT2A" , "mirko123", "1234"));
        persons.add(new Teacher("Jack", "Sparrow", 2, LocalDate.of(1997, 2,1), 3000, "jack123", "1234"));
        persons.add(new Manager("Antonio", "Bellosguardo", 3, LocalDate.of(1998,3,11), "anto123","1234"));

    }

    public void deleteByID(int index){

        this.persons.removeIf(person -> person.getID() == index);
    }

    public List<Student> returnStudentsList(){
        List<Student> students = new ArrayList<>();

        for (Person p : persons) {
            if (p.getClass() == Student.class)
                students.add((Student)p);
        }

        return students;
    }

    public List<Teacher> returnTeacherList(){
        List<Teacher> teachers = new ArrayList<>();

        for (Person p : persons){
            if (p.getClass() == Teacher.class)
                teachers.add((Teacher) p);
        }
        return teachers;
    }


    public void printList(){

        System.out.println();
        System.out.println("current list");
        System.out.println();
        for (Person p : persons)
            System.out.println(p);
    }


}
