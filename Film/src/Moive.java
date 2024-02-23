public class Moive extends Film{
    private int time;

    public Moive() {
    }

    public Moive(int id, String title, Type type, double ranking, int time) {
        super(id, title, type, ranking);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Moive{" +
                "id=" + getId() + "," +
                "title=" + getTitle()+ "," +
                "type=" + getType()+ "," +
                "ranking=" + getRanking() + "," +
                "time=" + time +
                '}';
    }
}
