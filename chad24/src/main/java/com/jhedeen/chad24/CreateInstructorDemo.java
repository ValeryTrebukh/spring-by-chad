package com.jhedeen.chad24;

import com.jhedeen.chad24.entity.Course;
import com.jhedeen.chad24.entity.Instructor;
import com.jhedeen.chad24.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Mike", "Hodge", "hmike@mail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.udemy.com", "coding");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
