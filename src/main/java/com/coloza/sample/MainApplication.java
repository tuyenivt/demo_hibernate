package com.coloza.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coloza.sample.entity.Student;

public class MainApplication {

    public void createStudent(String firstName, String lastName, String email) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Student student = new Student(firstName, lastName, email);
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    public Student readStudent(int studentId) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Student student = null;
        try {
            session.beginTransaction();
            student = session.get(Student.class, studentId);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        return student;
    }
}
