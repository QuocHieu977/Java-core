package entities;

import statics.CustomerType;
import utils.IOUtil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Serializable {
    private static int autoId = 1000;
    private int id;
    private String name;
    private String address;
    private String phone;
    private CustomerType type;

    public Customer() {
        this.id = ++autoId;
    }

    public Customer(String name, String address, String phone, CustomerType type) {
        this.id = ++autoId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String
    toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type.value +
                '}' + "\n";
    }

    public void inputNewCustomer() {
        System.out.print("Mời bạn nhập tên khách hàng: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Mời bạn nhập địa chỉ: ");
        address = new Scanner(System.in).nextLine();
        System.out.print("Mời bạn nhập số điện thoại: ");
        while (true) {
            String temPhone = new Scanner(System.in).nextLine();
            if (temPhone.matches("^[0-9]{10}$")) {
                phone = temPhone;
                break;
            }
            System.out.print("Số điện thoại không đúng. Mời bạn nhập lại: : ");
        }

        System.out.println("Mời bạn chọn loại khách hàng: ");
        System.out.println("1. Khách hàng cá nhân");
        System.out.println("2. Đơn vị hành chính");
        System.out.println("3. Đơn vị kinh doanh");
        System.out.print("Chọn: ");

        int choose = IOUtil.integerNumber(1, 3, "Vui lòng bạn chọn lại từ 1 đến 3");
        switch (choose) {
            case 1:
                type = CustomerType.PERSONAL;
                break;
            case 2:
                type = CustomerType.ADMINISTRATIVE;
                break;
            case 3:
                type = CustomerType.BUSINESS;
                break;
        }
    }
}
