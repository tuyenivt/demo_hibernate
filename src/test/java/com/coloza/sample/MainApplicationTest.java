package com.coloza.sample;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.coloza.sample.entity.Student;

public class MainApplicationTest {

    private MainApplication app = new MainApplication();

    @Before
    public void setup() {
        System.setProperty("hibernate.generate_statistics", "true");
    }

    @Test
    public void testCreateStudent() {
        app.createStudent("firstName", "lastName", "email@gmail.com");
    }

    @Test
    public void testReadStudent() {
        Student student = app.readStudent(1);
        System.out.println("Got: " + (student == null ? "null" : student.getFirstName() + " " + student.getLastName()));
    }

    @Test
    public void testQueryStudent() {
        List<Student> students = app.queryStudent("name");
        System.out.println("Got: " + (students == null || students.isEmpty() ? "0" : students.size()) + " student(s)");
    }

}
