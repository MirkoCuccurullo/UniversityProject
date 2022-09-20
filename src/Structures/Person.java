package Structures;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int ID;
    private LocalDate birthDate;
    private int age;
    private String username;
    private String password;

    protected Person(String firstName, String lastName, int ID, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.birthDate = birthDate;
        this.age = setAge(this.birthDate);
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

    private int setAge(LocalDate date){
        return Period.between(LocalDate.now(), date).getYears();
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

@Override
    public String toString(){
        return ID + "         " + firstName + "             " + lastName +
                "       " + birthDate + "      " + age;
    }


}
