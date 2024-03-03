import View.Menu;
import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        Menu menu = new Menu();
        menu.display(scanner, users);
    }
}