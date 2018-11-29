package com.jhedeen.chad24;

import com.jhedeen.chad24.entity.Instructor;
import com.jhedeen.chad24.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor);

            if(instructor!=null) {
                System.out.println("Deleting " + instructor);
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
