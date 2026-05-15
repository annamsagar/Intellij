package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop lap = new Laptop();
        lap.setBrand("Asus");
        lap.setModel("tuf");
        lap.setRam(16);
        lap.setLid(1);

        Laptop lap1 = new Laptop();
        lap1.setBrand("Asus");
        lap1.setModel("rog");
        lap1.setRam(32);
        lap1.setLid(2);

        Laptop lap2 = new Laptop();
        lap2.setBrand("Lenovo");
        lap2.setModel("Thinkpad");
        lap2.setRam(8);
        lap2.setLid(3);

        Aliean s=new Aliean();
        s.setAid(101);
        s.setAname("bhairaava");
        s.setTech("java");

        Aliean a2=new Aliean();
        a2.setAid(102);
        a2.setAname("jagadeesh");
        a2.setTech("python");

        Aliean a3=new Aliean();
        a3.setAid(103);
        a3.setAname("surya");
        a3.setTech("ml");

        s.setLaptops(Arrays.asList(lap,lap1));
        a2.setLaptops(Arrays.asList(lap1,lap2));
        a3.setLaptops(Arrays.asList(lap));

        lap.setAid(Arrays.asList(s,a3));
        lap1.setAid(Arrays.asList(s,a2));
        lap2.setAid(Arrays.asList(a3));
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Aliean.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
                //cfg.buildSessionFactory();
        Session s1=sf.openSession();
        Transaction trans=s1.beginTransaction();
        s1.persist(lap);
        s1.persist(lap1);
        s1.persist(s);
        s1.persist(lap2);
        s1.persist(a2);
        s1.persist(a3);
        Aliean a5=s1.find(Aliean.class,1);

        trans.commit();
        s1.close();
        sf.close();
        System.out.println(a5);
    }
}
