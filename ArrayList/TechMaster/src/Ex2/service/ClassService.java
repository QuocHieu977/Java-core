package Ex2.service;

import Ex2.entities.Class;
import Ex2.entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassService {
    public Class inputClass(Scanner scanner) {
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        System.out.print("Mời bạn nhập khoá học: ");
        String course = scanner.nextLine();
        System.out.print("Mời bạn nhập học kỳ: ");
        String semester = scanner.nextLine();
        StudentService studentService = new StudentService();
        ArrayList<Student> students = studentService.saveStudent(scanner);
        return new Class(nameClass, course, semester, students);
    }
    public void saveClass(Scanner scanner, ArrayList<Class> classes) {
        String choose;
        do {
            classes.add(inputClass(scanner));
            System.out.println("Bạn có muốn nhập thêm lớp hay không(Y/N): ");
            choose = scanner.nextLine();
        } while (!choose.equalsIgnoreCase("n"));
    }
}
