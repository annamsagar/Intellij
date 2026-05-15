package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop lap = new Laptop();
        lap.setBrand("Asus");
        lap.setModel("strix");
        lap.setRam(64);
        lap.setLid(4);


        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Aliean.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
                //cfg.buildSessionFactory();
        Session s1=sf.openSession();
        Query query=s1.createQuery("from Laptop where brand='Asus' ",Laptop.class);
        List<Laptop> l2=query.getResultList();
        System.out.println(l2);
        s1.close();
        sf.close();
    }
}
