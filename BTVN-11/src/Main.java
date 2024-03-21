import View.View;
import entities.Bank;
import entities.Customer;
import entities.Saving;
import utils.Type;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("a", "hanoi", 849607855, Type.PERSONAL));

        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank("acb", 1.0));

        ArrayList<Saving> savings = new ArrayList<>();

        View view = new View();
        view.display(scanner, customers, banks, savings);
    }
}