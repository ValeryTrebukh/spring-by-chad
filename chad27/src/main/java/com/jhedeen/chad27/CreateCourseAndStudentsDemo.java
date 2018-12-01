package com.jhedeen.chad27;

import com.jhedeen.chad27.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            Course course = new Course("Pacman - How to score one million points");

            System.out.println(course);
            session.save(course);

            Student student1 = new Student("John", "Hedeen", "jhedeen@mail.com");
            Student student2 = new Student("Jenny", "Hedeen", "j2hedeen@mail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);

            System.out.println(course.getStudents());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
