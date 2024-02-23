package RankingMatch.entities;

import java.util.ArrayList;

public class SKT {
    ArrayList<Figure> figures;

    public SKT(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public String toString() {
        return "SKT{" +
                "figures=" + figures +
                '}';
    }
}
