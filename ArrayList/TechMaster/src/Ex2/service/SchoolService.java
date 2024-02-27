package Ex2.service;

import Ex2.entities.Class;
import Ex2.entities.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SchoolService {
    public void inputInfo(Scanner scanner, ArrayList<Class> classes) {
        ClassService classService = new ClassService();
        classService.saveClass(scanner, classes);
    }
    public void print(ArrayList<Class> classes){
        System.out.println("================================");
        for(Class e: classes) {
            ArrayList<Student> students = e.getStudents();
            System.out.println("Lớp: " + e.getNameClass());
            System.out.println("Khoá học: " + e.getCoures());
            System.out.println("Học kỳ: " + e.getSemester());
            System.out.println("Danh sách học sinh: ");
            System.out.printf("%-20s%-20s%-20s\n", "Họ và Tên", "Ngày sinh", "Quê quán");
            for(Student st: students) {
                st.print();
            }
            System.out.println();
        }
        System.out.println("================================");
    }
    public void filter(ArrayList<Class> classes) {
        System.out.println("Danh sách học sinh: ");
        System.out.printf("%-20s%-20s%-20s\n", "Họ và Tên", "Ngày sinh", "Quê quán");
        for(Class e: classes) {
            ArrayList<Student> students = e.getStudents();
            for(Student st: students) {
                if (st.getDateOfBirth().getYear() == 1985 && st.getHomeTown().equalsIgnoreCase("thai nguyen"))
                    st.print();
            }
        }

    }
    public void filterByClass(ArrayList<Class> classes) {
        ArrayList<Class> newClasses = new ArrayList<>();
        for(Class e: classes) {
            if(e.getNameClass().equalsIgnoreCase("10a1"))
                newClasses.add(e);
        }
        print(newClasses);
    }
}
