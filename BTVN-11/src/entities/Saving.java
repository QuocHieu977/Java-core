package entities;


import java.time.LocalDate;

public class Saving {
    Bank bank;
    private double deposit;
    private LocalDate createDate;

    public Saving() {
        createDate = LocalDate.now();
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Saving{" +
                ", bank=" + bank +
                ", deposit=" + deposit +
                ", createDate=" + createDate +
                '}';
    }
}
