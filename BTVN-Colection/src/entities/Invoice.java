package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Invoice {
    private Customer customer;
    private ArrayList<Service> services;

    public Invoice() {
    }

    public Invoice(Customer customer, ArrayList<Service> services) {
        this.customer = customer;
        this.services = services;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", services=" + services +
                '}' +"\n";
    }
}
