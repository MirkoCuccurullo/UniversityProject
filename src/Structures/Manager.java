package Structures;

import java.time.LocalDate;

public class Manager extends Person{
    public Manager(String firstName, String lastName, int ID, LocalDate birthDate, String username, String password) {
        super(firstName, lastName, ID, birthDate);
        this.setPassword(password);
        this.setUsername(username);
    }

    public String toString(){
        return getFirstName() + " " + getLastName();
    }

}
