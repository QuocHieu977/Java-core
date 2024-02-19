import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        String name;
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

                    do {
                        System.out.print("Nhập điểm java: ");
                        java = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhập điểm html: ");
                        html = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhập điểm css: ");
                        css = Double.parseDouble(sc.nextLine());

                        if(java<0 || java>10 || html<0 || html>10 || css<0 || css>10) {
                            System.out.println("Vui lòng nhập điểm!");
                        }
                    } while (java<0 || java>10 || html<0 || html>10 || css<0 || css>10);


                    listSV[i] = new SinhVienIT(name, "IT", java, html, css);
                    break;
                case 2:
                    System.out.print("Nhập tên: ");
                    name = sc.nextLine();

                    do {
                        System.out.print("Nhập điểm marketing: ");
                        marketing = Double.parseDouble(sc.nextLine());
                        System.out.print("Nhập điểm sales: ");
                        sales = Double.parseDouble(sc.nextLine());

                        if(marketing <0 || marketing>10 || sales<0 || sales>10) {
                            System.out.println("Vui lòng nhập lại điểm!");
                        }
                    } while (marketing <0 || marketing>10 || sales<0 || sales>10);

                    listSV[i] = new SInhVienBiz(name, "Biz", marketing, sales);
                    break;
                default:
                    System.out.println("Nhập lại...");
                    break;
            }
        }

        for (SinhVienTechMaster sv : listSV) {
            sv.xuat();
        }

        System.out.println("Lọc theo nghành: ");
        String fMajors = sc.nextLine();
        findOfMajors(listSV, fMajors);
    }

    public static void findOfMajors(SinhVienTechMaster[] listSV, String majors) {
            for(SinhVienTechMaster sv: listSV) {
                if(sv.getMajors().equalsIgnoreCase(majors)) {
                    sv.xuat();
                }
            }
    }
}