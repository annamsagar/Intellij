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
        s.setRollNo(3);
        s.setAge(39);
        s.setSname("sri ram");
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
                //cfg.buildSessionFactory();
        Session s1=sf.openSession();
        //Transaction trans=s1.beginTransaction();
        //s1.persist(s);
        s1.find(Student.class,2);
        //trans.commit();
        s1.close();
        sf.close();
        System.out.println(s);
    }
}
