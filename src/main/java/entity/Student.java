package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grade;
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "StudentCourse")
    @Embedded
    List<Course> courses;

    public Student(){}

    public Student(String name, String grade, Address address){
        this(null, name, grade, address, null);
    }
    public Student(String name, String grade, Address address, List<Course> courses){
        this(null, name, grade, address, courses);
    }

    public Student(Long id, String name, String grade, Address address, List<Course> courses){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
