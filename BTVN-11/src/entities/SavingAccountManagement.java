package entities;

import java.util.List;

public class SavingAccountManagement {
    private Customer customer;
    private List<Saving> savings;

    public SavingAccountManagement() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Saving> getSavings() {
        return savings;
    }

    public void setSavings(List<Saving> savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "SavingAccountManagement{" +
                "customer=" + customer +
                ", savings=" + savings +
                '}';
    }
}
