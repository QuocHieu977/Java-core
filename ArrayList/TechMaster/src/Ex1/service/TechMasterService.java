package Ex1.service;

import Ex1.entities.Class;
import Ex1.entities.Student;
import Ex1.entities.TechMaster;

import java.util.ArrayList;
import java.util.Scanner;

public class TechMasterService {
    public TechMaster inputInfoTechMaster(Scanner scanner,  ArrayList<Student> students) {
        System.out.print("Mời bạn nhập tên quản lý: ");
        String managerName = scanner.nextLine();
        System.out.print("Mời bạn nhập tên giảng viên: ");
        String lectures = scanner.nextLine();
        ClassService classService = new ClassService();
        Class classes = classService.inputClass(scanner, students);
        return new TechMaster(managerName, lectures, classes);
    }
    public void saveTechMaster(Scanner scanner, ArrayList<TechMaster> techMasters,  ArrayList<Student> students) {
        techMasters.add(inputInfoTechMaster(scanner, students));
    }
    public void print(ArrayList<TechMaster> techMasters) {
        for (TechMaster e: techMasters) {
            System.out.println("============================");
            Class classes = e.getClasses();
            System.out.println("Quản lý: " + e.getManagerName());
            System.out.println("Giảng viên: " + e.getLectures());
            System.out.println("Môn học: " + classes.getSubject());
            System.out.println("Danh sách học viên: ");
            System.out.printf("%-20s%-20s%-20s%-20s\n", "id", "Tên", "Tuổi", "Học lực");
            for (int i = 0; i < classes.getStudents().size(); i++) {
                System.out.printf("%-20d%-20s%-20d%-20s\n"
                        , classes.getStudents().get(i).getId()
                        , classes.getStudents().get(i).getName()
                        , classes.getStudents().get(i).getOldYear()
                        , classes.getStudents().get(i).getClassify());
            }
            System.out.println("============================");
        }
    }
    public void addStudent(Scanner scanner,  ArrayList<Student> students) {
        StudentService studentService = new StudentService();
        studentService.saveStudent(scanner, students);
    }
    public void updateStudent(int id, String uClassify, ArrayList<Student> students) {
        for(Student st: students) {
            if (st.getId() == id)
                st.setClassify(uClassify);
        }
    }
    public void deleteStudent(String name, ArrayList<Student> students){
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).getName().equalsIgnoreCase(name))
                students.remove(students.get(i));
        }
    }
}
