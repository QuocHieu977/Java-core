package entities;

import utils.IOUtil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Service implements Serializable {
    private static int autoId = 100;
    private int id;
    private String description;
    private double rates;

    public Service() {
        this.id = ++autoId;
    }

    public Service(String description, double rates) {
        this.id = ++autoId;
        this.description = description;
        this.rates = rates;
    }

    public int getId() {
        return id;
    }

    public static int getAutoId() {
        return autoId;
    }

    public String getDescription() {
        return description;
    }

    public double getRates() {
        return rates;
    }

    public double billing(int capacity) {
        return capacity * rates;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rates=" + rates +
                '}' + "\n";
    }

    public void inputNewService() {
        System.out.print("Mời bạn nhập mô tả dịch vụ: ");
        description = new Scanner(System.in).nextLine();
        System.out.print("Mời nhập bạn giá cước dịch vụ: ");
        rates = IOUtil.doubleNumber("Vui lòng nhập lại: ");
    }
}
