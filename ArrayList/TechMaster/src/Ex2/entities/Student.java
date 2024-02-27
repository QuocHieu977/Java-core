package Ex2.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private String name;
    private LocalDate dateOfBirth;
    private String homeTown;

    public Student(String name, LocalDate dateOfBirth, String homeTown) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void print() {
        System.out.printf("%-20s%-20s%-20s\n",name, dateOfBirth, homeTown);
    }
}
