package entity;

import javax.persistence.*;

@Embeddable
public class Course {

    private String name;

    public Course(){}

    public Course(String name) {
        this.name = name;
    }
}
