package entities;

import statics.CustomerType;
import java.util.Scanner;

public class Customer {
    private static int autoId = 1000;
    private int id;
    private String name;
    private String phone;
    private CustomerType type;

    public Customer(){
        this.id = ++autoId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type.value +
                '}' +"\n";
    }

    public void inputNewCustomer(Scanner scanner) {
        System.out.print("Mời bạn nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Mời bạn nhập SDT: ");
        phone = scanner.nextLine();
        System.out.println("Mời bạn chọn loại khách hàng: ");
        System.out.println("1. Khách hàng cá nhân");
        System.out.println("2. Đơn vị hành chính");
        System.out.println("3. Đơn vị kinh doanh");

        int choose;

        while (true) {
            try {
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <1 || choose > 3)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không phù hợp. Mời bạn chọn lại");
            }
        }
        switch (choose) {
            case 1:
                this.setType(CustomerType.PERSONAL);
                break;
            case 2:
                this.setType(CustomerType.ADMINISTRATIVE);
                break;
            case 3:
                this.setType(CustomerType.BUSINESS);
                break;
        }
    }
}
