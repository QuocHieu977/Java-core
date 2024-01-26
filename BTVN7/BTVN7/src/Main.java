import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập chiều dài HCN: ");
        int length= Integer.parseInt(sc.nextLine());
        System.out.print("Mời bạn nhập chiều rộng HCN: ");
        int width = Integer.parseInt(sc.nextLine());

        HinhChuNhat hcn = new HinhChuNhat(length, width);
        int sHCN = hcn.dienTichHCN(length, width);
        int pHCN = hcn.chuViHCN(length, width);

        System.out.println("S= " +sHCN);
        System.out.println("P= " +pHCN);
        System.out.println(hcn);

        System.out.print("Mời ban nhập cạnh của hình vuông: ");
        int side = Integer.parseInt(sc.nextLine());

        HinhVuong hv = new HinhVuong(side);
        int sHV = hv.dienTichHV(side);
        int pHV = hv.chuViHV(side);

        System.out.println("S= " +sHV);
        System.out.println("P= "+pHV);
        System.out.println(hv);
    }
}