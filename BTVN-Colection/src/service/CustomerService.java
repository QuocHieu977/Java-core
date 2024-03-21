package service;

import entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void inputCustomer(Scanner scanner) {
        System.out.println("Nhập vào số lượng khách hàng: ");
        int customerNumber;
        while (true) {
            try {
                customerNumber = Integer.parseInt(scanner.nextLine());
                if (customerNumber < 0)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại..");
            }
        }


        for (int i=0; i<customerNumber; i++) {
            Customer customer = new Customer();
            System.out.println("Nhập vào khách hàng thứ " +(i+1));
            customer.inputNewCustomer(scanner);
            customers.add(customer);
        }
        System.out.println(customers);
    }

    public Customer findById(int id) {
        for (Customer e: customers) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }
}
