package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Instructor;
import com.luvtocode.hibernate.demo.entity.InstructorDetail;
import com.luvtocode.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
       
		// create session factory 
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session 
      
		Session session =factory.getCurrentSession();
		
		
		try {
			//create the object 
			
			Instructor tempInstructor = new Instructor("Ayush","Rastogi","ayu@gmail.com");
			
			InstructorDetail tempInstructorDetail = new 
					InstructorDetail("http//www.ayu.com",
							"Code!!");
			
			
			//associate the objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction 
			session.beginTransaction();
			
			//save the instructor
			
			System.out.println("Saving Instructor : " + tempInstructor);
			session.save(tempInstructor);// this will also save the instructor detail object becoz we have used cascade all so it will save or delete all associated table 
			
			
			
			//commit transaction 
			session.getTransaction().commit();
			System.out.println("done.. !");
			
		}
	  finally {
		  factory.close();
	  }
	}
	

}
