package service;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

import utils.LoginContains;
import utils.LoginContains_2;

public class LoginService {
    public void loginAccount(Scanner scanner, ArrayList<User> users) {
        if (users.isEmpty()) {
            System.out.println("No account. Please create a new account");
        } else {
            User user = inputLogin(scanner, users);
            if (user == null) {
                menuLoginFailed(scanner, users);
            } else {
                menuLoginSuccess(scanner, user);
            }
        }
    }

    public void menuLoginSuccess(Scanner scanner, User user) {
        System.out.println("========= Welcome " + user.getName() + " =========");
        int choose;
        do {
            menuSub();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case LoginContains.CHANGE_USER:
                    changeUserInfo(scanner, user, "username");
                    break;
                case LoginContains.CHANGE_EMAIL:
                    changeUserInfo(scanner, user, "email");
                    break;
                case LoginContains.CHANGE_PASSWORD:
                    changeUserInfo(scanner, user, "password");
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

    public void menuLoginFailed(Scanner scanner, ArrayList<User> users) {
        System.out.println("1. Re-login");
        System.out.println("2. Forgot password");
        int check = Integer.parseInt(scanner.nextLine());
        switch (check) {
            case LoginContains_2.RE_LOGIN:
                loginAccount(scanner, users);
                break;
            case LoginContains_2.FORGOT_PASSWORD:
                forgotPassword(scanner, users);
                break;
        }
    }

    public User inputLogin(Scanner scanner, ArrayList<User> users) {
        if (users == null) {
            System.out.println("users is null - #LoginService - checkLogin");
        } else {
            int countUser = 0, countPassword = 0;
            String userName;
            do {
                System.out.print("Enter username: ");
                userName = scanner.nextLine();
                for (User e : users) {
                    if (e.getName().equals(userName))
                        countUser++;
                }
                if (countUser == 0) {
                    System.out.println("Username is wrong.");
                }
            } while (countUser <= 0);
            System.out.print("Enter password: ");
            String passWord = scanner.nextLine();
            for (User e : users) {
                if (!e.getPassword().equals(passWord)) {
                    countPassword++;
                    break;
                }
                if (e.getName().equalsIgnoreCase(userName) && e.getPassword().equals(passWord))
                    return e;
            }
            if (countPassword > 0) {
                System.out.println("Password is wrong.");
            }
        }
        return null;
    }

    public void forgotPassword(Scanner scanner, ArrayList<User> users) {
        if (users == null) {
            System.out.println("user is null - #LoginService - forgotPassword");
        } else {
            boolean checkMail;
            do {
                UserService userService = new UserService();
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                checkMail = userService.emailValidator(email);
                if (checkMail) {
                    int count = 0;
                    for (User e : users) {
                        if (e.getMail().equals(email)) {
                            changeUserInfo(scanner, e, "password");
                            break;
                        } else
                            count++;
                    }
                    if (users.isEmpty() || count > 0)
                        System.out.println("Email is not exist. Please register account");
                } else
                    System.out.println("Email format error");
            } while (!checkMail);
        }
    }

    public void changeUserInfo(Scanner scanner, User user, String nameInfoChange) {
        System.out.print("Enter new your " + nameInfoChange + ": ");
        String newNameInfo = scanner.nextLine();
        UserService userService = new UserService();
        if (nameInfoChange.equalsIgnoreCase("username")) {
            if (user.getName().equals(newNameInfo))
                System.out.println("Please enter another name...");
            else {
                user.setName(newNameInfo);
                System.out.println("You are change username successfully");
            }
        } else if (nameInfoChange.equalsIgnoreCase("email")) {
            if (userService.emailValidator(newNameInfo)) {
                if (user.getMail().equals(newNameInfo))
                    System.out.println("Please enter another email...");
                else {
                    user.setMail(newNameInfo);
                    System.out.println("You are change email successfully");
                }
            } else
                System.out.println("Email format error");
        } else if (nameInfoChange.equalsIgnoreCase("password")) {
            if (userService.passwordValidator(newNameInfo)) {
                if (user.getPassword().equals(newNameInfo))
                    System.out.println("Please enter another password...");
                else {
                    user.setPassword(newNameInfo);
                    System.out.println("You are change password successfully");
                }
            } else
                System.out.println("Please enter a password from 7 to 15 characters, containing at least 1 capital letter, 1 special character");
        } else
            System.out.println("This information cannot be changed..");
    }

    public void menuSub() {
        System.out.println("1. Change the username");
        System.out.println("2. Change the email");
        System.out.println("3. Change the password");
        System.out.println("4. Logout");
        System.out.println("0. Exit");
    }
}
