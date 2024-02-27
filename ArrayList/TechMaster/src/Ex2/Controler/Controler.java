package Ex2.Controler;

import Ex2.entities.Class;
import Ex2.entities.Student;
import Ex2.service.SchoolService;

import java.util.ArrayList;
import java.util.Scanner;

public class Controler {
    public void display(Scanner scanner) {
        SchoolService schoolService = new SchoolService();
        ArrayList<Class> classes = new ArrayList<>();
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    schoolService.inputInfo(scanner, classes);
                    break;
                case 2:
                    schoolService.print(classes);
                    break;
                case 3:
                    schoolService.filter(classes);
                    break;
                case 4:
                    schoolService.filterByClass(classes);
                    break;
                case 5:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!!!");
                    break;
            }
        } while (choose !=5);
    }
    public void showMenu() {
        System.out.println("1. Nhập một sách gồm n học sinh");
        System.out.println("2. Hiển thị tất cả học sinh");
        System.out.println("3. Hiển thị ra màn hình tất cả những học sinh sinh năm 1985 và quê ở Thái Nguyên");
        System.out.println("4. Hiển thị ra màn hình tất cả những học sinh của lớp 10A1");
        System.out.println("5. Thoát");
        System.out.println("Chọn: ");
    }
}
