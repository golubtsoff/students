package entity;

import org.h2.engine.Constants;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students")
@SecondaryTables({
        @SecondaryTable(name = "hobbies"),
        @SecondaryTable(name = "addresses"),
})
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(table = "hobbies")
    private String hobby;
    @Column(table = "addresses")
    @Embedded
    private Address address;

    public Student(){}

    public Student(String name, String hobby){
        this(null, name, hobby);
    }

    public Student(Long id, String name, String hobby){
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
