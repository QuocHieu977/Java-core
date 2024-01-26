import java.util.Scanner;

public class Doctor extends Person{
    private String specialist; // chuyên khoa
    private float workHour; // số giờ làm vc

    public Doctor() {

    }

    public Doctor(String name, int age, String address, String specialist, float workHour) {
        super(name, age, address);
        this.specialist = specialist;
        this.workHour = workHour;
    }

    @Override
    public void input() {
        super.input();

        Scanner sc = new Scanner(System.in);
        System.out.print("\tMời bạn chuyên khoa: ");
        specialist = sc.nextLine();
        System.out.print("\tMời bạn nhập số giờ làm việc: ");
        workHour = Float.parseFloat(sc.nextLine());
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Chuyên khoa: " +specialist);
        System.out.println("Số giờ làm việc: " +workHour);
    }
}
