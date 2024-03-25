package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOUtil {
    public static int integerNumber(int min, int max, String error) {
        while (true) {
            int result;
            try {
                result = new Scanner(System.in).nextInt();
                if (result < min || result > max){
                    throw new InputMismatchException();
                }
                return result;
            } catch (InputMismatchException e) {
                System.out.print(error);
            }
        }
    }

    public static int integerNumber(int min, String error) {
        while (true) {
            int result;
            try {
                result = new Scanner(System.in).nextInt();
                if (result < min){
                    throw new InputMismatchException();
                }
                return result;
            } catch (InputMismatchException e) {
                System.out.print(error);
            }
        }
    }


    public static double doubleNumber(String error) {
        while (true) {
            double result;
            try {
                result = new Scanner(System.in).nextDouble();
                return result;
            } catch (InputMismatchException e) {
                System.out.print(error);
            }
        }
    }
}
