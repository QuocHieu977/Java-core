package service;


import entities.User;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserService {
    public boolean emailValidator(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        return pattern.matcher(email).matches();
    }
    public boolean passwordValidator(String password) {
        if (password.length() >= 7 && password.length() <= 15) {
            int countChar = 0, countCharSpecical = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i)))
                    countChar++;
                if (!Character.isLetterOrDigit(password.charAt(i)) && !Character.isWhitespace(password.charAt(i)))
                    countCharSpecical++;
            }
            return countChar > 0 && countCharSpecical > 0;
        } else
            return false;
    }
    public User findByName(String userName, ArrayList<User> users) {
        for (User e : users) {
            if (e.getName().equals(userName))
                return e;
        }
        return null;
    }
    public User findByEmail(String email, ArrayList<User> users) {
        for (User e : users) {
            if (e.getMail().equalsIgnoreCase(email))
                return e;
        }
        return null;
    }
}
