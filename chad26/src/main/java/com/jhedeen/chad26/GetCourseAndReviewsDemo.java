package com.jhedeen.chad26;

import com.jhedeen.chad26.entity.Course;
import com.jhedeen.chad26.entity.Instructor;
import com.jhedeen.chad26.entity.InstructorDetail;
import com.jhedeen.chad26.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);
            System.out.println(course);
            System.out.println(course.getReviews());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
