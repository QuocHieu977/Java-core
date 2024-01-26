import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Patient extends Person{
    private String medicalNumber; // số bệnh án
    private LocalDate hopitalizeDay; // ngày nhập viện

    public Patient() {

    }
    public Patient(String name, int age, String address, String medicalNumber, LocalDate hopitalizeDay) {
        super(name, age, address);
        this.medicalNumber = medicalNumber;
        this.hopitalizeDay = hopitalizeDay;
    }

    @Override
    public void input() {
        super.input();

        Scanner sc = new Scanner(System.in);
        System.out.print("\tMời bạn nhập số bệnh án: ");
        medicalNumber = sc.nextLine();
        System.out.print("\tMời bạn nhập ngày nhập viện(dd/MM/yyyy): ");
        hopitalizeDay = stringToDate(sc.nextLine());
    }

    public LocalDate stringToDate(String day) {
        return LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Số bệnh án: " +medicalNumber);
        System.out.println("Ngày nhập viện: " + hopitalizeDay);
    }
}
