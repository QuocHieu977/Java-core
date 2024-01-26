import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {

    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\tMời bạn nhập tên: ");
        name = sc.nextLine();
        System.out.print("\tMời bạn nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("\tMời bạn nhập địa chỉ: ");
        address = sc.nextLine();
    }

    public void display() {
        System.out.println("Họ và tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Địa chỉ: " + address);
    }
}
