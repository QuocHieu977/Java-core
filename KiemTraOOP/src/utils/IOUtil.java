package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOUtil {
    public static int intNumberInteger(int min, int max, String error) {
        int result;
        while (true) {
            try {
                result = new Scanner(System.in).nextInt();
                if (result < min || result > max)
                    throw new InputMismatchException();
                return result;
            } catch (InputMismatchException e){
                System.out.println(error);
            }
        }
    }
}
