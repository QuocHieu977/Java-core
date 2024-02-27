import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listInteger = new ArrayList<>();

        listInteger.add(8);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);

        for(Integer i: listInteger) {
            System.out.print(i + "\t");
        }
        System.out.println();

        Collections.sort(listInteger);

        for(Integer i: listInteger) {
            System.out.print(i + "\t");
        }

    }
}