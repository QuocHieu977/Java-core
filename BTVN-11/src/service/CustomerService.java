package service;

import entities.Customer;

import utils.Type;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    public void inputCustomer(Scanner scanner, ArrayList<Customer> customers) {
        String check;
        do {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            if(findByNameCustomer(name, customers) == null) {
                System.out.print("Enter your address: ");
                String address = scanner.nextLine();
                int phone;
                do {
                    try {
                        System.out.print("Enter your phone number: ");
                        phone = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please you enter number...");
                    }

                } while (true);

                System.out.println("Choose customer type: :");
                System.out.println("1. PERSONAL");
                System.out.println("2. GROUPS");
                System.out.println("3. BUSINESSES");

                Type type = null;
                int choose;
                do {
                    try {
                        choose = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please you enter number...");
                    }

                } while (true);

                switch (choose) {
                    case 1:
                        type = Type.PERSONAL;
                        break;
                    case 2:
                        type = Type.GROUPS;
                        break;
                    case 3:
                        type = Type.BUSINESSES;
                        break;
                    default:
                        System.out.println("Please enter again");
                }
                customers.add(new Customer(name, address, phone, type));
            } else
                System.out.println("this customer existed. Please enter another customer");

            System.out.println("Do you want more customers?(Y/N): ");
            check = scanner.nextLine();
        }while (!check.equalsIgnoreCase("n"));
        System.out.println(customers);
    }
    public Customer findByNameCustomer(String name, ArrayList<Customer> customers) {
        for (Customer e: customers) {
            if (e.getName().contains(name))
                return e;
        }
        return null;
    }
    public void totalDeposit(ArrayList<Customer> customers) {
//        ArrayList<Customer> newCustomers = new ArrayList<>(customers);
//        for(int i=0; i<newCustomers.size(); i++) {
//            for(int j=i+1; j<newCustomers.size(); j++){
//                if (newCustomers.get(i).getName().equalsIgnoreCase(newCustomers.get(j).getName())) {
//                    newCustomers.remove(j);
//                    j--;
//                }
//            }
//        }
        System.out.format("%-15s%-20s\n", "Name", "Deposit");
        for(Customer e: customers) {
            System.out.format("%-15s%-20f\n", e.getName(), e.totalDeposit());
        }
    }

}
