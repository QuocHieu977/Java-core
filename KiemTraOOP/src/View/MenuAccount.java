package View;

import entities.Account;

import java.util.Scanner;

import service.AccountService;
import statics.LoginContains;
import statics.LoginContains_2;
import utils.IOUtil;

public class MenuAccount {
    final AccountService accountService = new AccountService();

    public void menuLoginSuccessfully(Scanner scanner, Account user) {
        System.out.println("================ Xin chào " + user.getName() + " ================");

        int choose;
        do {
            showMenu();
            choose = IOUtil.intNumberInteger(0, 4, "Vui lòng nhập lại lựa chọn 1 - 4");

            switch (choose) {
                case LoginContains.CHANGE_USER:
                    accountService.userNameChange(scanner, user);
                    break;
                case LoginContains.CHANGE_EMAIL:
                    accountService.emailChange(scanner, user);
                    break;
                case LoginContains.CHANGE_PASSWORD:
                    accountService.passwordChange(scanner, user);
                    break;
                case LoginContains.LOGOUT:
                    break;
                case LoginContains.EXIT:
                    System.exit(0);
            }
        } while (choose !=4);
    }

    public void menuLoginFailure(Scanner scanner, Account user) {
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");

        int choose = IOUtil.intNumberInteger(1,2, "Vui lòng nhập lại lựa chọn từ 1 - 2");
        switch (choose) {
            case LoginContains_2.RE_LOGIN:
                break;
            case LoginContains_2.FORGOT_PASSWORD:
                accountService.forgotPassword(scanner, user);
                break;
        }
    }

    public void showMenu() {
        System.out.println("1. Thay đổi tên");
        System.out.println("2. Thay đổi email");
        System.out.println("3. Thay đổi mật khẩu");
        System.out.println("4. Đăng xuất");
        System.out.println("0. Thoát");
        System.out.println("Chọn: ");
    }
}
