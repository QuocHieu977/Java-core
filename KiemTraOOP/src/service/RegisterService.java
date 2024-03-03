package service;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterService {
    public void createAccount(Scanner scanner, ArrayList<User> users) {
        if (users == null) {
            System.out.println("users is null - #RegisterService - createAccount");
        } else {
            UserService userService = new UserService();
            users.add(userService.inputUser(scanner, users));
            System.out.println("You created an account successfully...");
            System.out.println(users);
        }
    }
}
