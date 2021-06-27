package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	   
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			System.out.println("Create student data");
			
			Student stu = new Student("Tom","Ray","tom@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("save");
			
			session.save(stu);
			session.getTransaction().commit();
			
			//read data
			
			System.out.println("saved student. Generated id:" + stu.getId());
			
			
			// now get a new session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			
			System.out.println("\nGetting student with id : " + stu.getId());
			
			Student mystu = session.get(Student.class, stu.getId());
			
			System.out.println("Get Complete : " + mystu);
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("done");
	
		}
      finally {
    	  factory.close();
      }
	}

}
