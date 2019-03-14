package service;

import dao.*;
import entity.Course;
import exception.DBException;
import entity.Address;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

public class StudentService {

    public StudentService(){}

    public Student create(String name, String grade, Address address, List<Course> courses) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            StudentDao studentDao = DaoFactory.getStudentDao();
            Student student = new Student(name, grade, courses);
            student.setAddress(address);

            Long studentId = studentDao.create(student);

            student = studentDao.get(studentId);
            transaction.commit();
            return student;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
