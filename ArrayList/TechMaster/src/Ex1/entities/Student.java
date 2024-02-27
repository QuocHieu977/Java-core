package Ex1.entities;

public class Student {
    private int id;
    private String name;
    private int oldYear;
    private String classify;

    public Student(int id, String name, int oldYear, String classify) {
        this.id = id;
        this.name = name;
        this.oldYear = oldYear;
        this.classify = classify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOldYear() {
        return oldYear;
    }

    public void setOldYear(int oldYear) {
        this.oldYear = oldYear;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
