package service;

import entities.Bank;
import entities.Customer;
import utils.Type;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankService {
    public void inputBank(Scanner scanner, ArrayList<Bank> banks) {
        System.out.print("Mời bạn nhập số lượng ngân hàng cần thêm: ");
        int bankNumber;

        while (true) {
            try {
                bankNumber = Integer.parseInt(scanner.nextLine());
                if (bankNumber <=0)
                    throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập số lượng ngân hàng lớn hơn 0");
            }
        }

        for(int i=0; i<bankNumber; i++) {
            System.out.println("Mời bạn nhập ngân hàng thứ " + (i+1));
            Bank bank = new Bank();
            bank.inputNewBank(scanner);
            banks.add(bank);
        }

        System.out.println(banks);
    }

    public Bank findById(int id, ArrayList<Bank> banks) {
        for (Bank e : banks) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }
}
