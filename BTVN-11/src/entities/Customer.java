package entities;

import utils.Type;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer  {
    private static int autoId = 1001;
    private int id;
    private String name;
    private String address;
    private String phone;
    private Type type;

    public Customer() {
        this.id = ++autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type.value +
                '}' + "\n";
    }

    public void inputNewCustomer(Scanner scanner) {
        System.out.print("Mời bạn nhập vào tên: ");
        name = scanner.nextLine();
        System.out.print("Mời bạn nhập vào địa chỉ: ");
        address = scanner.nextLine();
        System.out.print("Mời bạn nhập vào SDT: ");

        while (true) {
            String temPhone = scanner.nextLine();
            if (temPhone.matches("[^0d\\{9}]")) {
                this.setPhone(temPhone);
                break;
            }
            System.out.println("Số điện thoại không đúng định dạng. Vui lòng nhập lại.");
        }

        System.out.print("Mời bạn chọn loại khách hàng: ");
        System.out.println("1. Khách hang cá nhân");
        System.out.println("2. Khách hang nhóm");
        System.out.println("3. Khách hang doanh nghiệp");
        int choose;
        while (true) {
            try{
                choose = Integer.parseInt(scanner.nextLine());
                if (choose <=0 || choose >3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Bạn nhập không đúng. Vui lòng nhập lại");
            }
        }
        switch (choose) {
            case 1:
                type = Type.PERSONAL;
                break;
            case 2:
                type = Type.GROUPS;
                break;
            case 3:
                type = Type.BUSINESSES;
                break;
        }
    }
}
