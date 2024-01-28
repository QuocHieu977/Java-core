import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều dài: ");
        double dai = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập chiều rộng: ");
        double rong = Double.parseDouble(sc.nextLine());
        System.out.println("nhập cạnh hv: ");
        double canh = Double.parseDouble(sc.nextLine());

        HinhHoc[] shapes = new HinhHoc[2];



        HinhHoc hcn = new ChuNhat(dai, rong);
        HinhHoc hv = new Vuong(canh);
        Vuong v = new Vuong(canh);
        shapes[0]=hcn;
        shapes[1]=hv;

        double a =shapes[0].getChuVi();
        double b =shapes[0].getDienTich();
        double c =shapes[0].getAB();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}