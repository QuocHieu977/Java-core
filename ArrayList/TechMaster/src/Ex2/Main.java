package Ex2;

import Ex2.Controler.Controler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Controler controler = new Controler();
        controler.display(scanner);
    }
}
