package service;

import dao.StudentDao;
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
            StudentDao dao = new StudentDao();
            Long id = dao.create(new Student(name, grade, address, courses));
            Student student = dao.get(id);

            transaction.commit();

            return student;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
