package View;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

import service.ModifyUser;
import utils.LoginContains;
import utils.LoginContains_2;

public class Menu {
    ModifyUser modifyUser = new ModifyUser();
    public void menuLoginSuccessfully(Scanner scanner, User user, ArrayList<User> users) {
        System.out.println("================ Welcome " + user.getName() + " ================");
        int choose;
        do {
            System.out.println("1. Change the username");
            System.out.println("2. Change the email");
            System.out.println("3. Change the password");
            System.out.println("4. Logout");
            System.out.println("0. Exit");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case LoginContains.CHANGE_USER:
                    modifyUser.userNameChange(scanner, user, users);
                    break;
                case LoginContains.CHANGE_EMAIL:
                    modifyUser.emailChange(scanner, user, users);
                    break;
                case LoginContains.CHANGE_PASSWORD:
                    modifyUser.passwordChange(scanner, user);
                    break;
                case LoginContains.LOGOUT:
                    break;
                case LoginContains.EXIT:
                    System.exit(0);
                default:
                    System.out.println("Please enter: ");
                    break;
            }
        } while (choose != 4);
    }
    public void menuLoginFailure(Scanner scanner, User user) {
        System.out.println("1. Re-login");
        System.out.println("2. Forgot password");
        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose) {
            case LoginContains_2.RE_LOGIN:
                break;
            case LoginContains_2.FORGOT_PASSWORD:
                modifyUser.forgotPassword(scanner, user);
                break;
        }
    }
}
