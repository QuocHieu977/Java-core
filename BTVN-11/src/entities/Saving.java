package entities;


public class Saving {
    private int term;
    private double deposit;
    private Customer customer;
    private Bank bank;

    public Saving(int term, double deposit, Customer customer, Bank bank) {
        this.term = term;
        this.deposit = deposit;
        this.customer = customer;
        this.bank = bank;
    }

    public Saving() {
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void addSaving(Customer customer) {
        customer.getSavings().add(this);
    }

    @Override
    public String toString() {
        return "Saving{" +
                "term=" + term +
                ", deposit=" + deposit +
                ", customer=" + customer + "\n" +
                ", bank=" + bank +
                '}' + "\n";
    }
}
