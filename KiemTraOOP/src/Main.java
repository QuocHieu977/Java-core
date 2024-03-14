import View.View;
import entities.User;
import service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("a", "a@gmail.com", "A123456@"));
        users.add(new User("b", "b@gmail.com", "B123456@"));
        users.add(new User("c", "c@gmail.com", "C123456@"));


        View view = new View();
        view.display(scanner, users);
    }
}