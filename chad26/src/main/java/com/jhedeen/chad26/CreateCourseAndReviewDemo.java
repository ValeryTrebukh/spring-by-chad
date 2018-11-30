package com.jhedeen.chad26;

import com.jhedeen.chad26.entity.Course;
import com.jhedeen.chad26.entity.Instructor;
import com.jhedeen.chad26.entity.InstructorDetail;
import com.jhedeen.chad26.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
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

            Course course = new Course("Pacman - How to score one million points");

            course.addReview(new Review("Great course"));
            course.addReview(new Review("Cool course"));
            course.addReview(new Review("What a dumb course!"));

            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
