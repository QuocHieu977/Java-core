package View;

import java.util.ArrayList;
import java.util.Scanner;

import entities.User;
import service.LoginService;
import service.RegisterService;
import utils.RegisterContants;
public class Menu {
    public void display(Scanner scanner, ArrayList<User> users) {
        RegisterService registerService = new RegisterService();
        LoginService loginService = new LoginService();

        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case RegisterContants.LOGIN:
                    loginService.loginAccount(scanner, users);
                    break;
                case RegisterContants.REGISTER:
                    registerService.createAccount(scanner, users);
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
