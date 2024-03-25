package View;

import java.util.Scanner;

import service.AccountService;
import statics.RegisterContants;
import utils.IOUtil;

public class View {
    public void display(Scanner scanner) {
        final AccountService accountService = new AccountService();
        int choose;

        do {
            showMenu();
            choose = IOUtil.intNumberInteger(1, 3, "Vui lòng nhập lại lưa chọn từ 1 - 3");

            switch (choose) {
                case RegisterContants.LOGIN:
                    accountService.loginAccount(scanner);
                    break;
                case RegisterContants.REGISTER:
                    accountService.insertAccount(scanner);
                    break;
            }

        } while (choose != 3);

    }

    public void showMenu() {
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Thoát");
        System.out.println("Chọn: ");
    }
}
