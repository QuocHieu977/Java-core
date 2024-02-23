import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id;
        String title;
        double ranking;
        int time;
        int number;
        int avagareTime;

        System.out.print("Nhập số lượng Movie: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng Series: ");
        int n1 = Integer.parseInt(sc.nextLine());

        Moive[] listMovie = new Moive[n];
        Series[] listSeries = new Series[n1];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập Movie thứ " + (i + 1));
            System.out.print("Nhập id: ");
            id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên phim: ");
            title = sc.nextLine();
            System.out.println("Chọn thể loại phim: ");
            Type type = typeChoose();
            System.out.print("Nhập ranking: ");
            ranking = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập thời lượng phim: ");
            time = Integer.parseInt(sc.nextLine());

            listMovie[i] = new Moive(id, title, type, ranking, time);
        }

        for (int i = 0; i < n1; i++) {
            System.out.println("Nhập Series Film thứ " + (i + 1));
            System.out.print("Nhập id: ");
            id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên phim: ");
            title = sc.nextLine();
            System.out.println("Chọn thể loại phim: ");
            Type type = typeChoose();
            System.out.print("Nhập ranking: ");
            ranking = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập số tập: ");
            number = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập thời lượng trung bình: ");
            avagareTime = Integer.parseInt(sc.nextLine());

            listSeries[i] = new Series(id, title, type, ranking, number, avagareTime);
        }

        for (Moive mv : listMovie) {
            System.out.println(mv);
        }

        for (Series ser : listSeries) {
            System.out.println(ser);
        }

        System.out.println("Nhập tên phim cần tim: ");
        String fTitle = sc.nextLine();
        findFilmOfTitle(listMovie, listSeries, fTitle);
        System.out.println("Film có ranking thấp nhất: ");
        findLowestRankFilm(listMovie, listSeries);
    }


    public static Type typeChoose() {
        Type type = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. HORROR");
        System.out.println("2. COMEDY");
        System.out.println("3. DOCUMENTATRY");
        System.out.println("4. WAR");
        System.out.println("5. ANIME");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                type = Type.HORROR;
                break;
            case 2:
                type = Type.COMEDY;
                break;
            case 3:
                type = Type.DOCUMENTATRY;
                break;
            case 4:
                type = Type.WAR;
                break;
            case 5:
                type = Type.ANIME;
                break;
            default:
                System.out.println("Vui lòng chọn thể loại phim!!!");
                break;
        }
        return type;
    }
    public static void findFilmOfTitle(Moive[] listMovies, Series[] listSeries, String title) {
        int n = listMovies.length + listSeries.length;
        int count = 0;
        Film[] listFilms = new Film[n];

        for (int i = 0; i < listMovies.length; i++) {
            listFilms[i] = listMovies[i];
        }

        for (int j = 0; j < listSeries.length; j++) {
            listFilms[j + listMovies.length] = listSeries[j];
        }

        for (Film film : listFilms) {
            if (film.getTitle().contains(title)) {
                count++;
                System.out.println(film);
            }
        }
        if (count <= 0)
            System.out.println("Not found...");


    }
    public static void findLowestRankFilm(Moive[] listMovies, Series[] listSeries) {
        int n = listMovies.length + listSeries.length;
        Film[] listFilms = new Film[n];
        double temp = 0;

        for (int i = 0; i < listMovies.length; i++) {
            listFilms[i] = listMovies[i];
        }

        for (int j = 0; j < listSeries.length; j++) {
            listFilms[j + listMovies.length] = listSeries[j];
        }

        for (int i = 1; i < listFilms.length; i++) {
            temp = listFilms[0].getRanking();
            if (listFilms[i].getRanking() < temp)
                temp = listFilms[i].getRanking();

        }

        for (Film film : listFilms) {
            if (temp == film.getRanking())
                System.out.println(film);
        }

    }
}