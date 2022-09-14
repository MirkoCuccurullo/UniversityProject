import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Teacher extends Person{
    double salary;

    public double getSalary(){
        return  salary;
    }
    public Teacher(String firstName, String lastName, int ID, LocalDate birthDate, int age, double salary, String username, String password){
        super(firstName, lastName, ID, birthDate, age);
        this.salary = salary;
        this.setUsername(username);
        this.setPassword(password);
    }

}
