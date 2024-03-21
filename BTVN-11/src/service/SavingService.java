package service;

import entities.Bank;
import entities.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingService {
    private final CustomerService customerService = new CustomerService();
    private final BankService bankService = new BankService();
    public void createSavingAccount(Scanner scanner, ArrayList<Customer> customers, ArrayList<Bank> banks) {
        System.out.print("Có bao nhiêu khách hàng muốn gửi sổ tiết kiệm: ");
        int customerNumber;
        while (true) {
            try {
                customerNumber = Integer.parseInt(scanner.nextLine());
                if (customerNumber <=0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập số nguyên dương lớn hơn 0");
            }
        }
        System.out.println("Nhập mã khách hàng: ");
        while (true) {
            Customer customer;
            try {
                int customerId = Integer.parseInt(scanner.nextLine());
                customer = customerService.findById(customerId, customers);
                if (customer != null)
                    break;
                throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Mã khách hàng không tồn tại. Vui lòng nhập lại");
            }
        }

        System.out.println("Nhập số lượng ngân hàng muốn gửi tiết kiệm: ");
        int bankNumber = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<bankNumber; i++) {
            System.out.println("Nhập thông tin cho sổ tiết kiệm thứ " + (i+1));
        }





        System.out.println("Nhập id ngân hàng: ");
        while (true) {
            Bank bank;
            try {
                int BankId = Integer.parseInt(scanner.nextLine());
                bank = bankService.findById(BankId, banks);
                if (bank != null)
                    break;
                throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Mã ngân hàng không tồn tại. Vui lòng nhập lại");
            }
        }

    }
}
