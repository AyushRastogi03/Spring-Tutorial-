package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Student;

public class pimaryKeydemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         SessionFactory factory = new Configuration()
        		 .configure("hibernate.cfg.xml")
        		 .addAnnotatedClass(Student.class)
        		 .buildSessionFactory();
         
         
         Session session = factory.getCurrentSession();
         
         try {
        	 System.out.println("Creating student object");
        	 
        	 Student stu1 = new Student("Ram","Roy","r@gmail.com");
        	 Student stu2 = new Student("Raj","toy","t@gmail.com");
        	 Student stu3 = new Student("Ravi","joy","j@gmail.com");
        	 
        	 //
        	 session.beginTransaction();
        	 
        	 //
        	 System.out.println("saving student");
        	 
        	 session.save(stu1);
        	 session.save(stu2);
        	 session.save(stu3);
        	 
        	 
        	 //
        	 
        	 session.getTransaction().commit();
        	 
        	 System.out.println("done..!");
        	 
        	 
         }
         finally {
        	 factory.close();
         }
	}

}
