public class Series extends Film{
    private int number;
    private int avagareTime;

    public Series() {
    }

    public Series(int id, String title, Type type, double ranking, int number, int avagareTime) {
        super(id, title, type, ranking);
        this.number = number;
        this.avagareTime = avagareTime;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAvagareTime() {
        return avagareTime;
    }

    public void setAvagareTime(int avagareTime) {
        this.avagareTime = avagareTime;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" +getId() + "," +
                "title=" +getTitle() + "," +
                "type=" +getType() + "," +
                "ranking=" +getRanking() + "," +
                "number=" + number + "," +
                "avagareTime=" + avagareTime +
                '}';
    }
}
