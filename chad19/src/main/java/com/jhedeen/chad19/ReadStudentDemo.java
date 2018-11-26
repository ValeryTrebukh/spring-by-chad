package com.jhedeen.chad19;

import com.jhedeen.chad19.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("Daffy", "Duck", "daffy@mail.com");
            session.beginTransaction();
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Saved Student id=" + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, tempStudent.getId());
            System.out.println(student);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
