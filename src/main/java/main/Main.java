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
        Address address = new Address("ул. Ленина");
        Address address2 = new Address("ул. Ленина");
        StudentService service = new StudentService();
        try {
            Student student = service.create(new Student("Вася", "Лыжи"), address);
            Student student2 = service.create(new Student("Петя", null), address);
        } catch (DBException e){
            System.out.println("что-то пошло не так");
        }
        DBService.close();
    }
}
