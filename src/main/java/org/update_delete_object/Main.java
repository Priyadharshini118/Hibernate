package org.update_delete_object;

import org.hibernate.Transaction;
import org.update_delete_object.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        s1.setRollNo(3);
        s1.setsName("raja");
        s1.setsAge(42); //I want to update Raja age as 42,


        SessionFactory sf=new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(s1); //to update

//        session.persist(s1);  //to save it
        transaction.commit();
        sf.close();
        System.out.println(s1);
    }
}