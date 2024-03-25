package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice implements Serializable {
    private Customer customer;
    private ArrayList<ServiceManger> serviceMangers;

    public Invoice(Customer customer, ArrayList<ServiceManger> serviceMangers) {
        this.customer = customer;
        this.serviceMangers = serviceMangers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<ServiceManger> getServiceMangers() {
        return serviceMangers;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", serviceMangers=" + serviceMangers +
                '}' + "\n";
    }
}
