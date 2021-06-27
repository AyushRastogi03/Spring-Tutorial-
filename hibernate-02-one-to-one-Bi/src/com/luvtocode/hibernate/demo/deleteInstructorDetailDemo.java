package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Instructor;
import com.luvtocode.hibernate.demo.entity.InstructorDetail;

public class deleteInstructorDetailDemo {

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
			
			//get the instructor detail object 
			
			int theId = 5;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
			
			
			//print instructor detail
			System.out.println("tempInstructorDetail : " + tempInstructorDetail);
			
			
			
			//print associated instructor
			
			System.out.println("the Associated Instructor : " + tempInstructorDetail.getInstructor());
			
			
			
			//remove from associated instructor 
			tempInstructorDetail.getInstructor().setInstructorDetail(null); // incase to delete only instructordetail but save instructor
			
			// delete instructor Detail
			session.delete(tempInstructorDetail);
		
            session.getTransaction().commit();
			
			System.out.println("done");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
