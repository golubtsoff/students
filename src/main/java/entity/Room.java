package entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    private Long id;

    @Column(name = "number")
    private int number;

//    TODO: Разобраться, почему, если убрать 'optional = false':
//    работает FetchType.LAZY, в противном случае LAZY надо поменять на EAGER
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn
    private Student student;

    public Room(){}

    public Room(int number, Student student) {
        this.id = student.getId();
        this.number = number;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
