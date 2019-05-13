package main;

import dao.DaoFactory;
import entity.Room;
import exception.DBException;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import service.DBService;
import service.RoomService;
import service.StudentService;
import entity.Address;
import entity.Student;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.transaction.Transactional;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        RoomService roomService = new RoomService();
        try {
            Student student = studentService.create(
                    new Student("Вася", "Лыжи", new Address("ул. Ленина", 7))
            );
            Student student2 = studentService.create(
                    new Student("Оля", "Хоккей", new Address("ул. Фрунзе", 4))
            );

            Room room = roomService.create(new Room(5, student));
            System.out.println(room);
            Room room2 = roomService.get(room.getId());
            Address address = room2.getStudent().getAddress();
            Student student1 = room2.getStudent();
            System.out.println(room2);

            PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();
            boolean isLoaded = persistenceUtil.isLoaded(room2.getStudent());
            Student student3 = room2.getStudent();

        } catch (DBException e){
            System.out.println("что-то пошло не так");
        }
        DBService.close();
    }
}
