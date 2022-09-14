import java.time.LocalDate;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int ID;
    private LocalDate birthDate;
    private int age;

    private String username;
    private String password;

    public Person(String firstName, String lastName, int ID, LocalDate birthDate, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        setBirthDate(birthDate);
        this.age = age;
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

    public LocalDate getBirthDate(){
        return getBirthDate();
    }

    public void setBirthDate(LocalDate date){
        this.birthDate = date;
    }

    public String toString(){
        return ID + "         " + firstName + "             " + lastName +
                "       " + birthDate + "      " + age;

    }
}
