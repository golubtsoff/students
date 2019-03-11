package dao;

import entity.Student;
import org.hibernate.LockMode;
import org.hibernate.Session;
import service.DBService;

import java.util.List;

public class StudentDao {

    public StudentDao() {
    }

    public Student get(long id) {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .get(Student.class, id, LockMode.PESSIMISTIC_READ);
    }

    public List<Student> getAll() {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .createQuery("from Student", Student.class)
                .list();
    }

    public long create(Student student) {
        return (Long) DBService.getSessionFactory()
                .getCurrentSession()
                .save(student);
    }

    public void update(Student student) {
        DBService.getSessionFactory().getCurrentSession()
                .update(student);
    }

    public Student delete(long id) {
        Session session = DBService.getSessionFactory().getCurrentSession();
        Student student = session.byId(Student.class).load(id);
        session.delete(student);
        return student;
    }

    public void deleteAll(){
        DBService.getSessionFactory()
                .getCurrentSession()
                .createQuery("delete from Student")
                .executeUpdate();
    }
}
