package com.jhedeen.chad19;

import com.jhedeen.chad19.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Paul", "Wall", "test@mail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
