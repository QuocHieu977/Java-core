package entities;

public class Bank {
    private static int autoId;
    private int id;
    private String name;
    private double interestRateDeposit;

    public Bank(String name, double interestRateDeposit) {
        this.id = ++autoId;
        this.name = name;
        this.interestRateDeposit = interestRateDeposit;
    }

    public String getId() {
        return String.format("%03d", id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterestRateDeposit() {
        return interestRateDeposit;
    }

    public void setInterestRateDeposit(double interestRateDeposit) {
        this.interestRateDeposit = interestRateDeposit;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", interestRateDeposit=" + interestRateDeposit +
                '}' + "\n";
    }
}
