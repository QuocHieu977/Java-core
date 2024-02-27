package Ex1.service;

import Ex1.entities.Class;
import Ex1.entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassService {
    public Class inputClass(Scanner scanner,  ArrayList<Student> students) {
        System.out.print("Mời bạn nhập môn học: ");
        String subject = scanner.nextLine();
        StudentService studentService = new StudentService();
        studentService.saveStudent(scanner, students);
        return new Class(subject, students);
    }
//    public ArrayList<Class> saveClass(Scanner scanner) {
//        ArrayList<Class> classes = new ArrayList<>();
//        classes.add(inputClass(scanner));
//        return classes;
//    }
}
