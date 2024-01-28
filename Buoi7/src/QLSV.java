import java.util.Scanner;

public class QLSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập số lượng sv: ");
        int n = Integer.parseInt(sc.nextLine());
        SinhVienTechMaster[] listSV = new SinhVienTechMaster[n];

        String name;
        String major;
        double java;
        double html;
        double css;
        double maketing;
        double sales;

        for (int i = 0; i < n; i++) {
            int choose;
            System.out.println("Nhập sv thứ "+(i+1));
            System.out.println("1. SinhVienIT");
            System.out.println("2. SinhVienBiz");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("Nhập tên: ");
                    name = sc.nextLine();
                    System.out.println("Nhập ngành học: ");
                    major = sc.nextLine();
                    System.out.println("Nhập điểm java: ");
                    java = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhập điểm html: ");
                    html = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhập điểm css: ");
                    css = Double.parseDouble(sc.nextLine());
                    listSV[i] = new SinhVienIT(name, major, java, html, css);
                    break;
                case 2:
                    System.out.println("Nhập tên: ");
                    name = sc.nextLine();
                    System.out.println("Nhập ngành học: ");
                    major = sc.nextLine();
                    System.out.println("Nhập điểm marketing: ");
                    maketing = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhập điểm sale: ");
                    sales = Double.parseDouble(sc.nextLine());
                    listSV[i] = new SinhVienBiz(name, major, maketing, sales);
                    break;
                default:
                    System.out.println("nhập lại...");
                    break;
            }


        }

        for (SinhVienTechMaster sv : listSV) {
            sv.printf();
        }

    }
}
