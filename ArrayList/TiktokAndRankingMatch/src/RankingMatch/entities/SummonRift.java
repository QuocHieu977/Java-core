package RankingMatch.entities;

import java.time.LocalTime;
import java.util.ArrayList;

public class SummonRift {
    private LocalTime timeMatch;
    ArrayList<Figure> sktTeam;
    ArrayList<Figure> g2Team;

    public SummonRift(LocalTime timeMatch, ArrayList<Figure> sktTeam, ArrayList<Figure> g2Team) {
        this.timeMatch = timeMatch;
        this.sktTeam = sktTeam;
        this.g2Team = g2Team;
    }
    @Override
    public String toString() {
        return "SummonRift{" + "\n" +
                "timeMatch=" + timeMatch + "\n" +
                "sktTeam=" + sktTeam + "\n" +
                "g2Team=" + g2Team + "\n" +
                '}';
    }
}
