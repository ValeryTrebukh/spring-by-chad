package com.jhedeen.chad24;

import com.jhedeen.chad24.entity.Course;
import com.jhedeen.chad24.entity.Instructor;
import com.jhedeen.chad24.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 11;
            Course course = session.get(Course.class, id);

            session.delete(course);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
