import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double result;
        String calculate;
        String check;

        do {
            System.out.print("Mời bạn nhập số a: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Mời bạn nhập số b: ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.print("Mời bạn nhập phép tính (+,-,*,/,%): ");
            calculate = sc.nextLine();

            switch (calculate) {
                case "-":
                    result = a-b;
                    System.out.println("Phép trừ: " + result);
                    break;
                case "*":
                    result = a*b;
                    System.out.println("Phép nhân: " + result);
                    break;
                case "/":
                    result = (double) a /b;
                    System.out.println("Phép chia: " + result);
                    break;
                case "%":
                    result = a%b;
                    System.out.println("Phép chia lấy dư: " + result);
                    break;
                default:
                    result = a+b;
                    System.out.println("Phép cộng: " + result);
                    break;
            }
            System.out.print("Do you want to continue(Y/N)?: ");
            check = sc.nextLine();
        } while (!check.equals("n"));
    }
}