public  class Film {
    private int id;
    private String title;
    private Type type;
    private double ranking;

    public Film() {
    }

    public Film(int id, String title, Type type, double ranking) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }
}
