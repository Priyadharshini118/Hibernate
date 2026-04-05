package org.crud_ops;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        s1.setRollNo(4);
        s1.setsName("selamatha");
        s1.setsAge(38);

        Student s2=null;
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.crud_ops.Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();

        s2=session.find(Student.class,4);


//to fetch we dont need transaction and save(persist)
//        Transaction transaction=session.beginTransaction();
//        session.persist(s1);  //to save it
//        transaction.commit();
        sf.close();
        System.out.println(s2);
    }
}