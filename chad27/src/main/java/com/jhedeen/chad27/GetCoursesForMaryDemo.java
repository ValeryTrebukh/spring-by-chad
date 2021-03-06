package com.jhedeen.chad27;

import com.jhedeen.chad27.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {
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

            System.out.println(jenny.getCourses());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
