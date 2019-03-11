package main;

import entity.Course;
import exception.DBException;
import service.DBService;
import service.StudentService;
import entity.Address;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("ул. Ленина", "Москва", "123");
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Физика"));
        courses.add(new Course("Литература"));
        StudentService service = new StudentService();
        try {
            Student student = service.create("Вася", "студент", address, courses);
        } catch (DBException e){
            System.out.println("что-то пошло не так");
        }
        DBService.close();
    }
}
