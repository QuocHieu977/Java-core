package RankingMatch;

import RankingMatch.entities.SummonRift;
import RankingMatch.service.SummonRiftService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SummonRift> summonRifts = new ArrayList<>();
        SummonRiftService summonRiftService = new SummonRiftService();
        summonRiftService.inputInfo(scanner, summonRifts);
    }
}
