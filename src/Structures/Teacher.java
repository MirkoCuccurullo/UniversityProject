package Structures;


import java.time.LocalDate;

public class Teacher extends Person {
    double salary;
    public Teacher(String firstName, String lastName, int ID, LocalDate birthDate, double salary, String username, String password){
        super(firstName, lastName, ID, birthDate);
        this.salary = salary;
        this.setUsername(username);
        this.setPassword(password);
    }

    public double getSalary(){
        return  salary;
    }


}
