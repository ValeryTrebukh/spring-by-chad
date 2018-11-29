package com.jhedeen.chad24;

import com.jhedeen.chad24.entity.Instructor;
import com.jhedeen.chad24.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(instructorDetail);
            instructorDetail.getInstructor().setInstructorDetail(null);

            if(instructorDetail!=null) {
                System.out.println("Deleting " + instructorDetail);
                session.delete(instructorDetail);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
