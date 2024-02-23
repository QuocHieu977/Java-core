package RankingMatch.service;

import RankingMatch.entities.Figure;
import RankingMatch.entities.SKT;

import java.util.ArrayList;
import java.util.Scanner;

public class SktService {
    public ArrayList<Figure> inputSktTeam(Scanner scanner) {
        System.out.println("Nhập thông tin team SKT: ");
        FigureService figureService = new FigureService();
        return figureService.saveFigure(scanner);
    }
}
