package com.luvtocode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hibernate.demo.entity.Student;

public class updateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		  
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				Session session = factory.getCurrentSession();
				
				
	  try {
		  session.beginTransaction();
		  int studentId = 1 ;
		  
		  System.out.println("saved student Generated Id :" + studentId);
		  
		  
		  Student mystu = session.get(Student.class,studentId);
		  
		  
		  System.out.println("-----Complete = " + mystu);
		  
		  //updating student 
		  
		  mystu.setFirstname("Scby");
		  
		  session.getTransaction().commit();
		  
		  
		  System.out.println("-----Complete = " + mystu);
		  
		  
		  // NEW cODE FOR EMAIL uPDATE FOR aLL
		  session = factory.getCurrentSession();
		  session.beginTransaction();
		  
		  System.out.println("updating student email for all");
		  
		  session.createQuery("update Student set email='foo@gmail.com'")
		  .executeUpdate();
		  
		  session.getTransaction().commit();
		  
		  System.out.println("done ... !");
		  
	  }
	  finally {
		  factory.close();
	  }
				
	}

}
