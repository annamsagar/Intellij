package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aliean s=new Aliean();
        s.setAid(1);
        s.setAname("bhairaava");
        s.setTech("java");
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Aliean.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
                //cfg.buildSessionFactory();
        Session s1=sf.openSession();
        Transaction trans=s1.beginTransaction();
        s1.persist(s);

        trans.commit();
        s1.close();
        sf.close();
        System.out.println(s);
    }
}
