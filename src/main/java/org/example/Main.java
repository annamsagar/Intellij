package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setRollNo(1);
        s.setAge(46);
        s.setSname("sagar");
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s1=sf.openSession();
        Transaction trans=s1.beginTransaction();
        s1.persist(s);
        trans.commit();
        System.out.println(s);
    }
}
