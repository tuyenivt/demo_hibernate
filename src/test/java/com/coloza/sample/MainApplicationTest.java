package com.coloza.sample;

import org.junit.Test;

import com.coloza.sample.entity.Student;

public class MainApplicationTest {

    private MainApplication app = new MainApplication();

    @Test
    public void testCreateStudent() {
        app.createStudent("firstName", "lastName", "email@gmail.com");
    }

    @Test
    public void testReadStudent() {
        Student student = app.readStudent(1);
        System.out.println("Got: " + (student == null ? "null" : student.getFirstName() + " " + student.getLastName()));
    }

}
