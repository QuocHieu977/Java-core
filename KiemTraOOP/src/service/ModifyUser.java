package service;

import View.Menu;
import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ModifyUser {
    UserService userService = new UserService();
    public User inputUser(Scanner scanner, ArrayList<User> users) {
        while (true) {
            System.out.print("Enter your username: ");
            String name = scanner.nextLine();
            if (userService.findByName(name, users) == null) {
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                if (userService.findByEmail(email, users) == null) {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (userService.emailValidator(email) && userService.passwordValidator(password))
                        return new User(name, email, password);
                    else {
                        if (!userService.emailValidator(email))
                            System.out.println("Email format error");
                        if (!userService.passwordValidator(password))
                            System.out.println("Please enter a password from 7 to 15 characters, containing at least 1 capital letter, 1 special character");
                    }
                } else {
                    System.out.println("Email existed!");
                }
            } else {
                System.out.println("Username existed");
            }
        }
    }
    public void insertAccount(Scanner scanner, ArrayList<User> users) {
        UserService userService = new UserService();
        users.add(inputUser(scanner, users));
        System.out.println("You created an account successfully...");
        System.out.println(users);
    }
    public void loginAccount(Scanner scanner, ArrayList<User> users) {
        String userName;
        User userCheck;
        do {
            System.out.print("Enter your username: ");
            userName = scanner.nextLine();
            userCheck = userService.findByName(userName, users);
            if(userCheck == null) {
                System.out.println("Username is wrong");
            } else {
                Menu menu = new Menu();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                if(userCheck.getPassword().equals(password)) {
                    System.out.println("You login successfully...");
                    menu.menuLoginSuccessfully(scanner, userCheck, users);
                } else {
                    System.out.println("Password is wrong");
                    menu.menuLoginFailure(scanner, userCheck);
                }
            }
        } while (userCheck == null);
    }
    public void userNameChange(Scanner scanner, User user, ArrayList<User> users) {
        System.out.print("Enter your new username: ");
        String newUserName = scanner.nextLine();
        User userCheck = userService.findByName(newUserName, users);

        if(userCheck == null) {
            user.setName(newUserName);
            System.out.println("You are change username successfully.");
        } else
            System.out.println("Username exited. Please enter another username.");
    }
    public void emailChange(Scanner scanner, User user, ArrayList<User> users) {
        System.out.print("Enter your new email: ");
        String newEmail = scanner.nextLine();
        User emailCheck = userService.findByEmail(newEmail, users);

        if(emailCheck == null) {
            if(userService.emailValidator(newEmail)) {
                user.setMail(newEmail);
                System.out.println("You are change email successfully.");
            } else
                System.out.println("Email error format");
        } else
            System.out.println("Email exited. Please enter another email.");
    }
    public void passwordChange(Scanner scanner, User user) {
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        if(user.getPassword().equals(newPassword))
            System.out.println("Please enter another password...");
        else {
            if(userService.passwordValidator(newPassword)){
                user.setPassword(newPassword);
                System.out.println("You are change password change successfully");
            } else
                System.out.println("Please enter a password from 7 to 15 characters, containing at least 1 capital letter, 1 special character");
        }
    }
    public void forgotPassword(Scanner scanner, User user) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if(user.getMail().equals(email)) {
            passwordChange(scanner, user);
        } else {
            System.out.println("Email no exist. Please register new an account");
        }
    }
}
