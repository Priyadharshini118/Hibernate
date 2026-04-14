package org.change_table_coln_name;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.change_table_coln_name.Student;


public class Main {
    public static void main(String[] args) {

        Alien a1=new Alien();

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        transaction.commit();
        sf.close();

    }
}