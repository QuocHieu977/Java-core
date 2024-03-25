package service;

import View.MenuAccount;
import entities.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountService {
    private final ArrayList<Account> accounts = new ArrayList<>();

    public AccountService() {
        accounts.add(new Account("a", "a@gmail.com", "A123456@"));
        accounts.add(new Account("b", "b@gmail.com", "B123456@"));
        accounts.add(new Account("c", "c@gmail.com", "C123456@"));
    }

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

    public Account findByName(String userName) {
        for (Account e : accounts) {
            if (e.getName().equals(userName))
                return e;
        }
        return null;
    }

    public Account findByEmail(String email) {
        for (Account e : accounts) {
            if (e.getMail().equalsIgnoreCase(email))
                return e;
        }
        return null;
    }

    public Account inputAccount(Scanner scanner) {
        while (true) {
            System.out.print("Mời bạn nhập tên đăng nhập: ");
            String name = scanner.nextLine();
            if (findByName(name) == null) {
                System.out.print("Mời bạn nhập email: ");
                String email = scanner.nextLine();
                if (findByEmail(email) == null) {
                    System.out.print("Mời banh nhập mật khẩu: ");
                    String password = scanner.nextLine();
                    if (emailValidator(email) && passwordValidator(password))
                        return new Account(name, email, password);
                    else {
                        if (!emailValidator(email))
                            System.out.println("Email lỗi dạng");
                        if (!passwordValidator(password))
                            System.out.println("Mật khẩu phải từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
                    }
                } else {
                    System.out.println("Email đã tồn tại!");
                }
            } else {
                System.out.println("Tên đăng nhập đã tồn tại");
            }
        }
    }

    public void insertAccount(Scanner scanner) {
        accounts.add(inputAccount(scanner));
        System.out.println("Bạn đã tạo tài thành công...");
        System.out.println(accounts);
    }

    public void loginAccount(Scanner scanner) {
        String userName;
        Account userCheck;
        do {
            System.out.print("Mời bạn nhập tên đăng nhập: "); //
            userName = scanner.nextLine();
            userCheck = findByName(userName);
            if(userCheck == null) {
                System.out.println("Tài khoản không tồn tại");
            } else {
                MenuAccount menu = new MenuAccount();
                System.out.print("Mời bạn nhập mật khẩu: ");
                String password = scanner.nextLine();
                if(userCheck.getPassword().equals(password)) {
                    System.out.println("Bạn đã đăng nhâp thành công");
                    menu.menuLoginSuccessfully(scanner, userCheck);
                } else {
                    System.out.println("Mật khẩu sai");
                    menu.menuLoginFailure(scanner, userCheck);
                }
            }
        } while (userCheck == null);
    }

    public void userNameChange(Scanner scanner, Account account) {
        System.out.print("Mời bạn nhập tên đăng nhập mới: ");
        String newUserName = scanner.nextLine();
        Account userCheck = findByName(newUserName);

        if(userCheck == null) {
            account.setName(newUserName);
            System.out.println("Bạn đã thay đổi tên thành công");
        } else
            System.out.println("Tên đăng nhập đã tồn tại. Mời bạn nhập tên đăng nhập khác");
    }

    public void emailChange(Scanner scanner, Account account) {
        System.out.print("Mời bạn nhập email mới: ");
        String newEmail = scanner.nextLine();
        Account emailCheck = findByEmail(newEmail);

        if(emailCheck == null) {
            if(emailValidator(newEmail)) {
                account.setMail(newEmail);
                System.out.println("Bạn đã thay đổi email thành công");
            } else
                System.out.println("Email lỗi định dạng");
        } else
            System.out.println("Email đã tồn tại. Mời bạn nhập email khác");
    }

    public void passwordChange(Scanner scanner, Account account) {
        System.out.print("Mời bạn nhập mật khẩu mới: ");
        String newPassword = scanner.nextLine();

        if(account.getPassword().equals(newPassword))
            System.out.println("Mời bạn nhập mật khẩu khác...");
        else {
            if(passwordValidator(newPassword)){
                account.setPassword(newPassword);
                System.out.println("Bạn đã thay đổi mật khẩu thành công");
            } else
                System.out.println("Mật khẩu phải từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
        }
    }

    public void forgotPassword(Scanner scanner, Account user) {
        System.out.print("Mời bạn nhập email: ");
        String email = scanner.nextLine();

        if(user.getMail().equals(email)) {
            passwordChange(scanner, user);
        } else {
            System.out.println("Email không tồn tại. Mời bạn đăng ký tài khoản mới");
        }
    }
}
