package entities;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Service {
    private static int autoId = 100;
    private int id;
    private String name;
    private double rates;
    private String unit;

    public Service(String name, double rates, String unit) {
        this.id = ++autoId;
        this.name = name;
        this.rates = rates;
        this.unit = unit;
    }

    public Service(){
        this.id = ++autoId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRates() {
        return rates;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Service{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", rates=" + rates +
                ", unit='" + unit + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Service service) {
            return service.getRates() == getRates() && service.getName().equals(getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRates(), getName());
    }

    public void inputNewService(Scanner scanner) {
        System.out.print("Mời bạn nhập tên dịch vụ: ");
        name = scanner.nextLine();
        System.out.print("Mời bạn nhập giá cước: ");

        while (true) {
            try {
                rates = Double.parseDouble(scanner.nextLine());
                if (rates <0)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lại...");
            }
        }

        System.out.print("Mời bạn nhập đơn vị tính: ");
        unit = scanner.nextLine();
    }
}
