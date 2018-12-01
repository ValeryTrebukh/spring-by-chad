package com.jhedeen.chad27;

import com.jhedeen.chad27.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int jennyId = 2;
            Student jenny = session.get(Student.class, jennyId);
            System.out.println(jenny);

            Course course1 = new Course("Rubik's Cube - How to speed cube");
            Course course2 = new Course("Atari 2600 - Game Development");

            course1.addStudent(jenny);
            course2.addStudent(jenny);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
