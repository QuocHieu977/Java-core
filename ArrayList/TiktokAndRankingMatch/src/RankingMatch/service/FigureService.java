package RankingMatch.service;

import RankingMatch.entities.Figure;

import java.util.ArrayList;
import java.util.Scanner;

public class FigureService {
    public Figure inputFigure(Scanner scanner) {
        System.out.print("Nhập tên tướng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập vị trí: ");
        String position = scanner.nextLine();
        return new Figure(name, position);
    }
    public ArrayList<Figure> saveFigure(Scanner scanner) {
        ArrayList<Figure> figures = new ArrayList<>();
//        System.out.print("Nhập số tướng: ");
//        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<3; i++) {
            System.out.println("Nhập tướng thứ " +(i+1));
            figures.add(inputFigure(scanner));
        }
        return figures;
    }
}
