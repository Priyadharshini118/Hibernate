package org.delete_object;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.delete_object.Student;


public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        // i want to delete priya(1)

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
        //I am getting the object
        s1=session.find(Student.class,1);

        Transaction transaction=session.beginTransaction();

        // Delete it
        session.remove(s1);

        transaction.commit();
        sf.close();
        System.out.println(s1);
    }
}