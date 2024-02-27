package Ex2.service;

import Ex2.entities.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    public Student inputStudent(Scanner scanner) {
        System.out.print("Mời bạn nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh học sinh: ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Mời bạn nhập quê quán học sinh: ");
        String homeTown = scanner.nextLine();
        return new Student(name, date, homeTown);
    }
    public ArrayList<Student> saveStudent(Scanner scanner)  {
        ArrayList<Student> students = new ArrayList<>();
        System.out.print("Mời bạn nhập số học sinh: ");
        int n;
        do {
             n = Integer.parseInt(scanner.nextLine());
            if (n<0) {
                System.out.println("Vui lòng nhập số học sinh lớn hơn 0!");
            }
        } while(n<0);
        for(int i=0; i<n; i++) {
            System.out.println("Nhập học sinh thứ " +(i+1));
            students.add(inputStudent(scanner));
        }
        return students;
    }

}
