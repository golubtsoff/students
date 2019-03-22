package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    private Long id;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @PrimaryKeyJoinColumn
    private Student student;

    private String street;

    public Address(){}

    public Address(Long id, String street){
        this.id = id;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
