import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Mời bạn nhập tên kho hàng: ");
        String nameWareHouse = sc.nextLine();
        System.out.print("Mời bạn nhập ngày tháng năm sinh (yyyy/MM/dd): ");
        String birthday = sc.nextLine();
        System.out.print("Mời bạn nhập thời gian nhập hàng (yyyy/MM/dd HH:mm:ss): ");
        String dateTime = sc.nextLine();
        System.out.print("Mời bạn nhập thời gian (HH:mm:ss): ");
        String time = sc.nextLine();

        LocalDate stringToDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDateTime stringToDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        LocalTime stringToTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeThreeDay = dateTimeNow.plusDays(3);

        System.out.println();
        System.out.println("Tên kho hàng: " + nameWareHouse);
        System.out.println("Ngày tháng năm sinh: " + stringToDate);
        System.out.println("Thời gian nhập hàng: " + stringToDateTime);
        System.out.println("Thời gian: " + stringToTime);
        System.out.println("Ngày giờ hiện tại: " + dateTimeNow);
        System.out.println("Ngày giờ 3 ngày sau: " + dateTimeThreeDay);

    }
}