package RankingMatch.service;

import RankingMatch.entities.Figure;
import RankingMatch.entities.G2;
import RankingMatch.entities.SKT;
import RankingMatch.entities.SummonRift;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SummonRiftService {
    public void inputInfo(Scanner scanner, ArrayList<SummonRift> summonRifts) {
        System.out.print("Mời bạn nhập thời gian trận đấu: ");
        String time = scanner.nextLine();
        LocalTime timeMatch = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
        SktService sktService = new SktService();
        ArrayList<Figure> sktTeam = sktService.inputSktTeam(scanner);
        G2Service g2Service = new G2Service();
        ArrayList<Figure> g2Team = g2Service.inputG2Team(scanner);
        summonRifts.add(new SummonRift(timeMatch, sktTeam, g2Team));
        System.out.println(summonRifts);
    }
}
