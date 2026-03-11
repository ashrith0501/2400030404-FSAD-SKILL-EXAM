package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        // ---------------- INSERT ----------------
        Transaction tx = session.beginTransaction();

        Department dept = new Department();
        dept.setName("CSE");
        dept.setDescription("Computer Science Department");
        dept.setDate(new Date());
        dept.setStatus("Active");
        dept.setLocation("Block A");

        session.save(dept);
        tx.commit();

        System.out.println("Inserted Successfully with ID: " + dept.getId());

        // ---------------- DELETE ----------------
        Transaction tx2 = session.beginTransaction();

        Department d = session.get(Department.class, dept.getId());

        if(d != null)
        {
            session.delete(d);
            System.out.println("Deleted Successfully");
        }

        tx2.commit();

        session.close();
        sf.close();
    }
}
