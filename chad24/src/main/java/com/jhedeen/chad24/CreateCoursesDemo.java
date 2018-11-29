package com.jhedeen.chad24;

import com.jhedeen.chad24.entity.Course;
import com.jhedeen.chad24.entity.Instructor;
import com.jhedeen.chad24.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("Guitar");
            Course course2 = new Course("Dombra");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
