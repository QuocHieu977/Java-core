package Ex1.service;

import Ex1.entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public Student inputStudent(Scanner scanner) {
        System.out.print("Mời bạn nhập id cho sinh viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên cho sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập tuổi cho sinh viên: ");
        int yearOld = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập học lực cho sinh viên: ");
        String classify = scanner.nextLine();
        return new Student(id, name, yearOld, classify);
    }
    public void saveStudent(Scanner scanner,  ArrayList<Student> students) {
        String choose;
        do {
            students.add(inputStudent(scanner));
            System.out.print("Bạn có muốn thêm sinh viên nữa không(Y/N): ");
            choose = scanner.nextLine();
        } while (!choose.equalsIgnoreCase("n"));
    }
}
