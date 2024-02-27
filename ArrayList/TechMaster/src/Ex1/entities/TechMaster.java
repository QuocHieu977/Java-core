package Ex1.entities;

import java.util.ArrayList;

public class TechMaster {
    private String managerName;
    private String lectures;
    private Class classes;

    public TechMaster() {

    }

    public TechMaster(String managerName, String lectures, Class classes) {
        this.managerName = managerName;
        this.lectures = lectures;
        this.classes = classes;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLectures() {
        return lectures;
    }

    public void setLectures(String lectures) {
        this.lectures = lectures;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }
}
