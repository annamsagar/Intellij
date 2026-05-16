package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
                //cfg.buildSessionFactory();
        Session s1=sf.openSession();

        Laptop l1=s1.find(Laptop.class,1);
        Laptop l2=s1.find(Laptop.class,2);
        System.out.println(l1);
        System.out.println(l2);

        s1.close();
        Session s2=sf.openSession();
        Laptop l3=s2.find(Laptop.class,3);
        System.out.println(l3);
        sf.close();
    }
}
