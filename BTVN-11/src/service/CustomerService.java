package service;

import entities.Customer;

import utils.Type;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService {
    public void inputCustomer(Scanner scanner, ArrayList<Customer> customers) {
        System.out.print("Mời bạn nhập số lượng khách hàng cần thêm: ");
        int customerNumber;
        while (true) {
            try {
                customerNumber = Integer.parseInt(scanner.nextLine());
                if (customerNumber <=0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập số lượng khách hàng lớn hơn 0");
            }
        }
        for(int i=0; i<customerNumber; i++) {
            Customer customer = new Customer();
            System.out.print("Mời bạn nhập khách hang thứ " + (i+1));
            customer.inputNewCustomer(scanner);
            customers.add(customer);
        }
        System.out.println(customers);
    }
    public Customer findById(int id, ArrayList<Customer> customers) {
        for (Customer e: customers) {
            if (e.getId() == id)
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
//        System.out.format("%-15s%-20s\n", "Name", "Deposit");
//        for(Customer e: customers) {
//            System.out.format("%-15s%-20f\n", e.getName(), e.totalDeposit());
//        }
    }

}
