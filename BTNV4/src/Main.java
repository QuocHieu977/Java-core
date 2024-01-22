import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.print("Mời b nhập vào số dòng: ");
            row = Integer.parseInt(sc.nextLine());
            System.out.print("Mời b nhập vào số cột: ");
            col = Integer.parseInt(sc.nextLine());

            if (row < 0 || col < 0) {
                System.out.println("Mời bạn nhập số dòng và số cột nguyên dương");
            }
        } while (row < 0 || col < 0);

        int sum = 0;
        int[][] arrInt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\tMời bạn nhập hàng " + (i + 1) + " cột " + (j + 1) + ": ");
                arrInt[i][j] = Integer.parseInt(sc.nextLine());

                if (arrInt[i][j] % 3 == 0) {
                    sum += arrInt[i][j];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arrInt[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Tổng các giá trị chia hết cho 3: " + sum);
    }
}