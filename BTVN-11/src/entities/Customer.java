package entities;

import utils.Type;

import java.util.ArrayList;

public class Customer extends TotalDeposit {
    private static int autoId;
    private int id;
    private String name;
    private String address;
    private int phone;
    private Type type;
    private ArrayList<Saving> savings;

    public Customer(String name, String address, int phone, Type type) {
        this.id = ++autoId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.savings = new ArrayList<>();
    }

    public Customer() {
        this.savings = new ArrayList<>();
    }

    public String getId() {
        return String.format("%05d", id);
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public ArrayList<Saving> getSavings() {
        return savings;
    }

    public void setSavings(ArrayList<Saving> savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}' + "\n";
    }

    @Override
    public double totalDeposit() {
        double sum = 0;
        for (Saving e : savings) {
            sum += e.getDeposit();
        }
        return sum;
    }
}
