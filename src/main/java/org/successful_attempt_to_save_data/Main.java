package org.successful_attempt_to_save_data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        s1.setRollNo(1);
        s1.setsName("priya");
        s1.setsAge(22);

        Configuration cfg=new Configuration();
        /*Exception: Unknown entity type 'org.successful_attempt_to_save_data.Student' ('Student' is not annotated '@Entity')*/
        cfg.addAnnotatedClass(org.successful_attempt_to_save_data.Student.class);
        cfg.configure();
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();

        Transaction transaction=session.beginTransaction();
        session.persist(s1);  //to save it
        transaction.commit();
        System.out.println(s1);
    }
}