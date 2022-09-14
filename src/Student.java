import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Student extends Person{
    private String group;

    public Student(String firstName, String lastName, int ID, LocalDate birthDate, String group, String username, String password){
        super(firstName, lastName, ID, birthDate);
        this.group = group;
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getGroup(){
        return group;
    }

    public String toString(){
        return super.toString() + "         " + group;
    }
}
