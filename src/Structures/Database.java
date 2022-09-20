package Structures;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Database {

    private List<Person> persons;

    public Database(){
        persons = new ArrayList<>();
        initialise(persons);
    }

    public List<Person> getPersons(){
        return persons;
    }

    private static void initialise(List<Person> persons){
        persons.add(new Student("Mirko", "Cuccurullo", 1, LocalDate.of(1997,05,10),"IT2A" , "mirko123", "1234"));
        persons.add(new Teacher("Jack", "Sparrow", 2, LocalDate.of(1997, 2,1), 3000, "jack123", "1234"));

    }
}
