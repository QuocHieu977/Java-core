package Ex2.entities;

import java.util.ArrayList;

public class Class {
    private String nameClass;
    private String coures;
    private String semester;
    ArrayList<Student> students;

    public Class(String nameClass, String coures, String semester, ArrayList<Student> students) {
        this.nameClass = nameClass;
        this.coures = coures;
        this.semester = semester;
        this.students = students;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getCoures() {
        return coures;
    }

    public void setCoures(String coures) {
        this.coures = coures;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
