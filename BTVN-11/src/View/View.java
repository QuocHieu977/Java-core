package View;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Bank;
import entities.Customer;
import entities.Saving;
import service.BankService;
import service.CustomerService;
import service.SavingService;
import utils.Contants;

public class View {
    public void display(Scanner scanner, ArrayList<Customer> customers, ArrayList<Bank> banks, ArrayList<Saving> savings) {
        CustomerService customerService = new CustomerService();
        BankService bankService = new BankService();
        SavingService savingService = new SavingService();

        int choose;
        do {
            showMenu();
            while (true) {
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter number");
                }
            }

            switch (choose) {
                case Contants.ENTER_CUSTOMER:
                    customerService.inputCustomer(scanner, customers);
                    break;
                case Contants.ENTER_BANK:
                    bankService.inputBank(scanner, banks);
                    break;
                case Contants.ENTER_SAVING:
                    savingService.inputSaving(scanner, savings, customers, banks);
                    break;
                case Contants.SORT_BY_NAME:
                    savingService.sortByNameCustomer(savings);
                    break;
                case Contants.SORT_BY_DEPOSIT:
                    savingService.sortByDeposit(savings);
                    break;
                case Contants.TOTAL_DEPOSIT_CUSTOMER:
                    customerService.totalDeposit(customers);
                    break;
                case Contants.EXIT:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Please choose again...");
                    break;
            }
        } while (choose !=7);
    }

    public void showMenu() {
        System.out.println("1. Enter the list Customers");
        System.out.println("2. Enter the list Banks");
        System.out.println("3. Enter the list Savings");
        System.out.println("4. Sort savings by name customer");
        System.out.println("5. Sort savings by deposit");
        System.out.println("6. Statistical total deposit for each customer");
        System.out.println("7. Exit");
        System.out.println("Choose: ");
    }
}
