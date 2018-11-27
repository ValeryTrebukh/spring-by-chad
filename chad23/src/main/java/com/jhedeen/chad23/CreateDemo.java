package com.jhedeen.chad23;

import com.jhedeen.chad23.entity.Instructor;
import com.jhedeen.chad23.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Mike", "Hodge", "hmike@mail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.udemy.com", "coding");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            System.out.println("Saving " + instructor);
            session.save(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
