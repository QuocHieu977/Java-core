package Ex1;

import Ex1.controler.Controler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Controler controler = new Controler();
        controler.display(scanner);
    }
}
