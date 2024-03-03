package service;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserService {
    public User inputUser(Scanner scanner, ArrayList<User> users) {
        while (true) {
            System.out.print("Enter your username: ");
            String name = scanner.nextLine();
            if (userNameValidator(name, users)) {
                System.out.println("Username existed");
            } else {
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                if (isMailExist(email, users)) {
                    System.out.println("Email existed!");
                }
                else {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (emailValidator(email) && passwordValidator(password))
                        return new User(name, email, password);
                    else {
                        if (!emailValidator(email))
                            System.out.println("Email format error");
                        if (!passwordValidator(password))
                            System.out.println("Please enter a password from 7 to 15 characters, containing at least 1 capital letter, 1 special character");
                    }
                }
            }
        }
    }
    public boolean isMailExist(String mail, ArrayList<User> users) {
        for (User e: users) {
            return e.getMail().equalsIgnoreCase(mail);
        }
        return false;
    }
    public boolean emailValidator(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        return pattern.matcher(email).matches();
    }
    public boolean passwordValidator(String password) {
        if (password.length() >=7 && password.length() <=15) {
            int countChar = 0, countCharSpecical = 0;
            for(int i=0; i<password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i)))
                    countChar++;
                if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i)))
                    countCharSpecical++;
            }
            return countChar > 0 && countCharSpecical > 0;
        } else
            return false;
    }
    public boolean userNameValidator(String userName, ArrayList<User> users) {
        for(User e: users) {
            return e.getName().equalsIgnoreCase(userName);
        }
        return false;
    }
}
