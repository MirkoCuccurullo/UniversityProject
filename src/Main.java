import Structures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person currentUser;

        Database DB = Database.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (Person p : DB.getPersons()){
            if (username.equals(p.getUsername()) && password.equals(p.getPassword())){

                currentUser = p;
                UI.displayView(DB.getPersons(),currentUser);
            }
        }

        scanner.close();
        System.out.println("Program closed.");
    }

}