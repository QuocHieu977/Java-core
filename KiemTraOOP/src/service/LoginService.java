package service;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

import utils.LoginContains;
import utils.LoginContains_2;

public class LoginService {
    public void menuLoginSuccess(Scanner scanner, User user, ArrayList<User> users) {
        System.out.println("========= Welcome " + user.getName() + " =========");
        int choose;
        do {
            menuSub();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case LoginContains.CHANGE_USER:
                    changeUserName(scanner, user, users);
                    break;
                case LoginContains.CHANGE_EMAIL:
                    changeEmail(scanner, user, users);
                    break;
                case LoginContains.CHANGE_PASSWORD:
                    changePassword(scanner, user);
                    break;
                case LoginContains.LOGOUT:
                    break;
                case LoginContains.EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please re-enter");
                    break;
            }
        } while (choose != 4);
    }
    public void menuLoginFailed(Scanner scanner, User user, ArrayList<User> users) {
        System.out.println("1. Re-login");
        System.out.println("2. Forgot password");
        int check = Integer.parseInt(scanner.nextLine());
        switch (check) {
            case LoginContains_2.RE_LOGIN:
                loginAccount(scanner, users);
                break;
            case LoginContains_2.FORGOT_PASSWORD:
                forgotPassword(scanner, user, users);
                break;
        }
    }
    public void loginAccount(Scanner scanner, ArrayList<User> users) {
        if (users == null) {
            System.out.println("users is null - #LoginService - checkLogin");
        } else {
            if (users.isEmpty()) {
                System.out.println("No account. Please create an account");
            } else {
                int countUser = 0;
                String userName;
                do {
                    System.out.print("Enter username: ");
                    userName = scanner.nextLine();
                    for (User e : users) {
                        if (e.getName().equals(userName)){
                            System.out.print("Enter password: ");
                            String passWord = scanner.nextLine();
                            if (!e.getPassword().equals(passWord)) {
                                countUser = 0;
                                System.out.println("Password is wrong.");
                                menuLoginFailed(scanner, e, users);
                            } else {
                                menuLoginSuccess(scanner, e, users);
                            }
                            break;
                        } else
                            countUser++;
                    }
                    if (countUser > 0) {
                        System.out.println("Username is wrong.");
                    }
                } while (countUser > 0);
            }
        }
    }
    public void forgotPassword(Scanner scanner, User user, ArrayList<User> users) {
        if (users == null) {
            System.out.println("user is null - #LoginService - forgotPassword");
        } else {
            int count;
            do {
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                count = 0;
                for (User e : users) {
                    if (e.getMail().equals(email) && e.getName().equals(user.getName())){
                        changePassword(scanner, e);
                        count++;
                        break;
                    }
                }
                if (count == 0)
                    System.out.println("Email invalidate");
            } while (count == 0);
        }
    }
    public void changeUserName(Scanner scanner, User user, ArrayList<User> users) {
        System.out.print("Enter new your username: ");
        String newName = scanner.nextLine();
        if (user.getName().equals(newName))
            System.out.println("Please enter another name...");
        else {
            int count = 0;
            for (User e : users) {
                if (e.getName().equals(newName)) {
                    count++;
                    break;
                }
            }
            if (count > 0)
                System.out.println("Please enter anther name...");
            else {
                user.setName(newName);
                System.out.println("You are change username successfully");
            }
        }
    }
    public void changeEmail(Scanner scanner, User user, ArrayList<User> users) {
        System.out.print("Enter new your email: ");
        String newEmail = scanner.nextLine();

        if (user.getMail().equals(newEmail))
            System.out.println("Please enter another email...");
        else {
            UserService userService = new UserService();
            if (userService.emailValidator(newEmail)) {
                int count = 0;
                for (User e : users) {
                    if (e.getMail().equals(newEmail)) {
                        count++;
                        break;
                    }
                }
                if (count > 0)
                    System.out.println("Please enter anther name...");
                else {
                    user.setMail(newEmail);
                    System.out.println("You are change email successfully");
                }
            } else
                System.out.println("Email format error");
        }
    }
    public void changePassword(Scanner scanner, User user) {
        System.out.print("Enter new your password: ");
        String newPassword = scanner.nextLine();

        if (user.getPassword().equals(newPassword))
            System.out.println("Please enter another password...");
        else {
            UserService userService = new UserService();
            if (userService.passwordValidator(newPassword)) {
                user.setPassword(newPassword);
                System.out.println("You are change password successfully");
            } else
                System.out.println("Please enter a password from 7 to 15 characters, containing at least 1 capital letter, 1 special character");
        }
    }
    public void menuSub() {
        System.out.println("1. Change the username");
        System.out.println("2. Change the email");
        System.out.println("3. Change the password");
        System.out.println("4. Logout");
        System.out.println("0. Exit");
    }
}
