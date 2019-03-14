package dao;

import entity.Student;

public class StudentDao extends AbstractDao<Student> {

    StudentDao() {
        super(Student.class);
    }
}
