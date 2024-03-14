package service;

import entities.Bank;
import entities.Customer;
import entities.Saving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SavingService {
    public void inputSaving(Scanner scanner, ArrayList<Saving> savings, ArrayList<Customer> customers, ArrayList<Bank> banks) {
        CustomerService customerService = new CustomerService();
        BankService bankService = new BankService();
        String check;

        do {
            Customer customer;
            String fName;
            do {
                System.out.print("Enter name customer want to create saving: ");
                fName = scanner.nextLine();
                customer = customerService.findByNameCustomer(fName, customers);
                if (customer == null) {
                    System.out.println("Not found customer");
                }
            } while (customer == null);

            if (checkSavingCustomer(fName, savings)) {
                Bank bank;
                do {
                    System.out.print("Enter name bank: ");
                    String fBank = scanner.nextLine();
                    bank = bankService.findByNameBank(fBank, banks);
                    if (bank == null) {
                        System.out.println("Not found bank");
                    }
                } while (bank == null);

                int term;
                double deposit;
                do {
                    try {
                        System.out.print("Enter term: ");
                        term = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter deposit: ");
                        deposit = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter number...");
                    }
                } while (true);
                try {
                    savings.add(new Saving(term, deposit, customer, bank));
                } catch (NullPointerException ex) {
                    System.out.println(" array saving is null - #inputSavings - #SavingService");
                }

                new Saving(term, deposit, customer, bank).addSaving(customer);
            } else
                System.out.println("This account can only create max of 5 savings.");

            System.out.println("Do you want more savings?(Y/N): ");
            check = scanner.nextLine();
        } while (!check.equalsIgnoreCase("n"));
        System.out.println(savings);
    }
    public boolean checkSavingCustomer(String name, ArrayList<Saving> savings) {
        int count = 0;
        try {
            for (Saving e: savings) {
                if (e.getCustomer().getName().equalsIgnoreCase(name)) {
                    count++;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("array savings is null - #checkSavingCustomer - #SavingsService");
        }
        return count < 5;
    }
    public void sortByNameCustomer(ArrayList<Saving> savings) {
        ArrayList<Saving> newSavings = new ArrayList<>(savings);
        newSavings.sort(new Comparator<Saving>() {
            @Override
            public int compare(Saving o1, Saving o2) {
                return o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
            }
        });
        System.out.println(newSavings);
    }
    public void sortByDeposit(ArrayList<Saving> savings) {
        ArrayList<Saving> newSavings = new ArrayList<>(savings);
        newSavings.sort(new Comparator<Saving>() {
            @Override
            public int compare(Saving o1, Saving o2) {
                return (int) (o1.getDeposit() - o2.getDeposit()) ;
            }
        });
        System.out.println(newSavings);
    }
}
