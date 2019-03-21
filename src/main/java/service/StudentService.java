package service;

import dao.*;
import exception.DBException;
import entity.Address;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class StudentService {

    public StudentService(){}

    public Student create(Student student, Address address) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            StudentDao studentDao = DaoFactory.getStudentDao();
            Long studentId = studentDao.create(student);

            address.setId(studentId);
            AddressDao addressDao = DaoFactory.getAddressDao();
            addressDao.create(address);

            transaction.commit();
            return student;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
