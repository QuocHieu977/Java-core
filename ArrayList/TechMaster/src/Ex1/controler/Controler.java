package Ex1.controler;

import java.util.ArrayList;
import java.util.Scanner;

import Ex1.entities.Student;
import Ex1.entities.TechMaster;
import Ex1.service.TechMasterService;
import Ex1.utils.Contants;

public class Controler {
    public void display(Scanner scanner) {
        TechMasterService techMasterService = new TechMasterService();
        ArrayList<TechMaster> techMasters = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case Contants.INPUT_INFO:
                     techMasterService.saveTechMaster(scanner, techMasters, students);
                    break;
                case Contants.INFORMATION_DISPLAY:
                    techMasterService.print(techMasters);
                    break;
                case Contants.ADD_STUDENT:
                    techMasterService.addStudent(scanner, students);
                    break;
                case Contants.UPDATE_STUDENT:
                    System.out.print("Mời bạn nhập id cần update: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mời bạn nhập học lực: ");
                    String uClassify = scanner.nextLine();
                    techMasterService.updateStudent(id, uClassify, students);
                    break;
                case Contants.DELETE_STUDENT:
                    System.out.println("Nhập tên cần xoá: ");
                    String dName = scanner.nextLine();
                    techMasterService.deleteStudent(dName, students);
                    break;
                case Contants.EXIT:
                    System.out.println("Thoát...");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!");
                    break;
            }
        } while (choose !=6);
    }
    public void showMenu() {
        System.out.println("1. Nhập thông tin");
        System.out.println("2. Hiện thị thông tin");
        System.out.println("3. Thêm học viên vào lớp");
        System.out.println("4. Cập nhật thông tin học viên");
        System.out.println("5. Xoá học viên");
        System.out.println("6. Thoát");
        System.out.println("Chọn: ");
    }
}
