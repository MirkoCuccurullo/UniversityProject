import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int ID;
    private LocalDate birthDate;
    private int age;
    private String username;
    private String password;

    public Person(String firstName, String lastName, int ID, String birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        setBirthDate(birthDate);
        this.age = setAge(this.birthDate);
    }

    public LocalDate getBirthDate(){

        return this.birthDate;
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getID(){
        return ID;
    }

    public int setAge(LocalDate date){
        return LocalDate.now().getYear() - date.getYear();
    }

    public int getAge(){
        return age;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public void setBirthDate(String dateString) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, dateTimeFormatter);
        this.birthDate = date;
    }

    public String toString(){
        return ID + "         " + firstName + "             " + lastName +
                "       " + birthDate + "      " + age;

    }
}
