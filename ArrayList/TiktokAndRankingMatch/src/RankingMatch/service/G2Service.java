package RankingMatch.service;

import RankingMatch.entities.Figure;

import java.util.ArrayList;
import java.util.Scanner;

public class G2Service {
    public ArrayList<Figure> inputG2Team(Scanner scanner) {
        System.out.println("Nhập thông tin team G2: ");
        FigureService figureService = new FigureService();
        return figureService.saveFigure(scanner);
    }
}
