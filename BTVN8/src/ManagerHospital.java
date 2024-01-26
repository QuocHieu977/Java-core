import java.util.Scanner;

public class ManagerHospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Nhập thông tin của bác sĩ
        System.out.print("Mời bạn nhập số bác sĩ: ");
        int n = Integer.parseInt(sc.nextLine());

        Doctor[] listDoctors = new Doctor[n];
        for(int i=0; i<n; i++) {
            Doctor bs = new Doctor();
            System.out.println("Mời bạn nhập bác sĩ thứ " +(i+1));
            bs.input();
            listDoctors[i] = bs;
        }

        //Nhập thông tin của bệnh nhân
        System.out.print("Mời bạn nhập số bệnh nhân: ");
        int n1 = Integer.parseInt(sc.nextLine());

        Patient[] listPatients = new Patient[n1];

        for (int i=0; i<n1 ; i++) {
            Patient bn = new Patient();
            System.out.println("Mời bạn nhập bệnh nhân thứ "+(i+1));
            bn.input();
            listPatients[i] = bn;
        }

        //hiện thông thông tin
        System.out.println("Danh sách các bác sĩ: ");
        for(Doctor bs: listDoctors) {
            bs.display();
        }

        System.out.println();
        System.out.println("Danh sách các bệnh nhân: ");
        for(Patient bn: listPatients) {
            bn.display();
        }
    }




}
