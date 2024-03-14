package service;

import entities.Bank;
import entities.Customer;
import utils.Type;

import java.util.ArrayList;
import java.util.Scanner;

public class BankService {
    public void inputBank(Scanner scanner, ArrayList<Bank> banks) {
        String check;
        do {
            System.out.print("Enter bank name: ");
            String name = scanner.nextLine();

            if(findByNameBank(name, banks) == null) {
                double interestRates;
                do {
                    try {
                        System.out.print("Enter bank interest rates: ");
                        interestRates = Double.parseDouble(scanner.nextLine());
                        if (interestRates > 0)
                            break;

                    } catch (NumberFormatException e) {
                        System.out.println("Please you enter number...");
                    }

                } while (true);
                banks.add(new Bank(name, interestRates));
            } else
                System.out.println("This bank existed. Please enter another bank");

            System.out.println("Do you want more bank?(Y/N): ");
            check = scanner.nextLine();
        }while (!check.equalsIgnoreCase("n"));
        System.out.println(banks);
    }

    public Bank findByNameBank(String name, ArrayList<Bank> banks) {
        for (Bank e: banks) {
            if (e.getName().equalsIgnoreCase(name))
                return e;
        }
        return null;
    }
}
