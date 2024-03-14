package View;

import java.util.ArrayList;
import java.util.Scanner;

import entities.User;
import service.ModifyUser;
import utils.RegisterContants;
public class View {
    public void display(Scanner scanner,  ArrayList<User> users) {
        ModifyUser modifyUser = new ModifyUser();

        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case RegisterContants.LOGIN:
                    modifyUser.loginAccount(scanner, users);
                    break;
                case RegisterContants.REGISTER:
                    modifyUser.insertAccount(scanner, users);
                    break;
                default:
                    System.out.println("Please re-enter: ");
                    break;
            }
        } while (choose !=0);
    }

    public void showMenu() {
        System.out.println("1 - Login");
        System.out.println("2 - Register");
    }


}
