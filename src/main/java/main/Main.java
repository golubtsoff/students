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
        StudentService service = new StudentService();
        try {
            Student student = service.create(
                    new Student("Вася", "Лыжи", new Address("ул. Ленина", 7))
            );
            Student student2 = service.create(
                    new Student("Петя", "Хоккей", new Address("ул. Фрунзе", 4))
            );
        } catch (DBException e){
            System.out.println("что-то пошло не так");
        }
        DBService.close();
    }
}
