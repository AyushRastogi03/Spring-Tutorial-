package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//int studentId = 5;
			
			session.beginTransaction();
			
			//System.out.println("Delete Student Id : " + studentId);
			
		//	Student myStu = session.get(Student.class,studentId);
			
			// delete the Student 
			
			//session.delete(myStu);
			
			
			// alternate Approach
			
			session.createQuery("delete from Student where id=4").executeUpdate();
			
			
			// commit the transaction 
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
		}
		finally{
			factory.close();
		}

	}

}
