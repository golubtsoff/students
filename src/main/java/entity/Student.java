package entity;

import org.h2.engine.Constants;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grade;

    @OneToOne(
            fetch = FetchType.EAGER,
            optional = true,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(unique = false)
    private Address address;

    @ElementCollection
    @CollectionTable(name = "StudentCourse")
    private List<Course> courses;

    @ElementCollection
    @CollectionTable(name = "hobby")
    @MapKeyColumn(name="id")
    @Column(name = "description")
    private Map<Integer, Hobby> hobbies;

    public Student(){}

    public Student(String name, String grade){
        this(null, name, grade, null);
    }
    public Student(String name, String grade, List<Course> courses){
        this(null, name, grade, courses);
    }

    public Student(Long id, String name, String grade, List<Course> courses){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.courses = courses;
        hobbies = new HashMap<>();
        hobbies.putIfAbsent(3, new Hobby("Алгебра"));
        hobbies.putIfAbsent(4, new Hobby("Геометрия"));
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
