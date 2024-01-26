import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập số nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        Employee[] listEmployee = new Employee[n];


        // thêm các nhân viên vào trong mảng
        for(int i=0; i< n; i++) {
            System.out.println("Mời bạn nhập nhân viên thứ "+(i+1));

            System.out.print("\tMời bạn nhập id: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("\tMời bạn nhập tên: ");
            String name = sc.nextLine();

            System.out.print("\tMời bạn nhập tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("\tMời bạn nhập kinh nghiệm làm việc: ");
            double exp = Double.parseDouble(sc.nextLine());

            System.out.print("\tMời bạn nhập nơi làm việc: ");
            String place= sc.nextLine();

            listEmployee[i] = new Employee(id, name, age, exp, place);
        }

        //in ra các nhân viên có trong mảng listEmployee
        for(Employee employee : listEmployee) {
            System.out.println(employee);
        }
    }
}