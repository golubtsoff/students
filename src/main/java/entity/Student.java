package entity;

import javax.persistence.*;

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

    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(table="addresses")),
            @AttributeOverride(name="building", column=@Column(table="addresses"))
    })
    private Address address;

    public Student(){}

    public Student(String name, String hobby, Address address){
        this.name = name;
        this.hobby = hobby;
        this.address = address;
    }
}
