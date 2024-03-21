package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private static int autoId = 100;
    private int id;
    private String name;
    private double interestRateDeposit;

    public Bank() {
        this.id = ++autoId;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", interestRateDeposit=" + interestRateDeposit +
                '}' + "\n";
    }

    public void inputNewBank(Scanner scanner) {
        System.out.print("Mời bạn nhập tên ngân hàng: ");
        name = scanner.nextLine();
        while (true) {
            try {
                System.out.print("Mời bạn nhập lãi suất: ");
                interestRateDeposit = Double.parseDouble(scanner.nextLine());
                if (interestRateDeposit <=0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn vui lòng nhập lãi suất lớn hơn 0.");
            }
        }

    }
}
