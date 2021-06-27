package com.luvtocode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.mapping.List;

import com.luvtocode.hibernate.demo.entity.Student;


//import antlr.collections.List;

public class QueryStudentDEmo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {

			session.beginTransaction();
			
			//query students
			
			List<Student> theStu = session.createQuery("from Student").getResultList();
			
			
			
			//display students
			
			displayStudent(theStu);
			
			
			// query student with last name Roy
			
			theStu = session.createQuery("from Student s where s.lastname='Roy'").getResultList();
		
			displayStudent(theStu);
		

			
			session.getTransaction().commit();
			
			System.out.println("Done ..!");
			
			
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudent(List<Student> theStu) {
		for(Student temp : theStu) {
			System.out.println(temp);
		}
	}

}
