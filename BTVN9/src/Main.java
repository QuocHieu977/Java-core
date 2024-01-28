import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        String name;
        String majors;
        double java;
        double html;
        double css;
        double marketing;
        double sales;

        do {
            System.out.print("Nhập vào số sinh viên: ");
            n = Integer.parseInt(sc.nextLine());
        } while (n < 0);

        SinhVienTechMaster[] listSV = new SinhVienTechMaster[n];

        for (int i = 0; i < n; i++) {
            int choose;
            System.out.println("Nhập sinh viên thứ " + (i + 1));
            do {
                System.out.println("1. Sinh viên IT");
                System.out.println("2. Sinh viên Biz");
                System.out.print("Chọn: ");
                choose = Integer.parseInt(sc.nextLine());
            } while (choose>2 || choose<1);

            switch (choose) {
                case 1:
                    System.out.print("Nhập tên: ");
                    name = sc.nextLine();
                    System.out.print("Nhập ngành học: ");
                    majors = sc.nextLine();
                    System.out.print("Nhập điểm java: ");
                    java = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập điểm html: ");
                    html = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập điểm css: ");
                    css = Double.parseDouble(sc.nextLine());

                    listSV[i] = new SinhVienIT(name, majors, java, html, css);
                    break;
                case 2:
                    System.out.print("Nhập tên: ");
                    name = sc.nextLine();
                    System.out.print("Nhập ngành học: ");
                    majors = sc.nextLine();
                    System.out.print("Nhập điểm marketing: ");
                    marketing = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập điểm sales: ");
                    sales = Double.parseDouble(sc.nextLine());

                    listSV[i] = new SInhVienBiz(name, majors, marketing, sales);
                    break;
                default:
                    System.out.println("Nhập lại...");
                    break;
            }
        }

        for (SinhVienTechMaster sv : listSV) {
            sv.xuat();
        }

    }
}