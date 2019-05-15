package service;

import dao.*;
import exception.DBException;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class StudentService {

    public StudentService(){}

    public Student create(Student student) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            StudentDao studentDao = DaoFactory.getStudentDao();
            studentDao.create(student);
            transaction.commit();
            return student;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
