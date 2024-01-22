import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowA;
        int colA;
        int rowB;
        int colB;

        System.out.println("Mời bạn nhập số dòng và cột cho ma trận A: ");
        do {
            System.out.print("Mời bạn nhập số dòng: ");
            rowA = Integer.parseInt(sc.nextLine());
            System.out.print("Mời bạn nhập số cột: ");
            colA = Integer.parseInt(sc.nextLine());

            if(rowA <0 || colA<0)
                System.out.println("Mời bạn nhập số dòng và số cột của ma trận A nguyên dương!");

        } while (rowA<0 || colA<0);

        int[][] matrixA = new int[rowA][colA];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                System.out.print("\tMời bạn nhập hàng " + (i + 1) + " cột " + (j + 1) + ": ");
                matrixA[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        System.out.println("Mời bạn nhập số dòng và cột cho ma trận B: ");
        do {
            System.out.print("Mời bạn nhập số dòng: ");
            rowB = Integer.parseInt(sc.nextLine());
            System.out.print("Mời bạn nhập số cột: ");
            colB = Integer.parseInt(sc.nextLine());

            if(rowB <0 || colB<0)
                System.out.println("Mời bạn nhập số dòng và số cột của ma trận B nguyên dương!");
        } while (rowB<0 || colB<0);

        int[][] matrixB = new int[rowB][colB];
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < colB; j++) {
                System.out.print("\tMời bạn nhập hàng " + (i + 1) + " cột " + (j + 1) + ": ");
                matrixB[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        //cộng 2 ma trận
        if (rowA == rowB && colA == colB) {
            int[][] matrixC = new int[rowA][colA];
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            // in ma trận
            for (int i=0; i<rowA; i++) {
                for(int j=0; j<colA; j++) {
                    System.out.print(matrixA[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("+");
            for (int i=0; i<rowB; i++) {
                for(int j=0; j<colB; j++) {
                    System.out.print(matrixB[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("=");
            for (int i=0; i<rowA; i++) {
                for(int j=0; j<colA; j++) {
                    System.out.print(matrixC[i][j] + "\t");
                }
                System.out.println();
            }
        } else
            System.out.println("Không thể thực hiện được phép cộng 2 ma trận.");

    }
}