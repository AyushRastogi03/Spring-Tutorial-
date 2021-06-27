package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Instructor;
import com.luvtocode.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// 
			int instructorid= 1;
			
			Instructor inst = session.get(Instructor.class,instructorid);
			
			session.delete(inst);
			
            session.getTransaction().commit();
			
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}

	}

}
