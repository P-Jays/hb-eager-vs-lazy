package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int num = 3;
			
	
			
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class,num);
			
			if(tempInstructor!= null) {
				System.out.println("deleting object with id num"+num);
				
				session.delete(tempInstructor);
			}else {
				System.out.println("this number id: "+num+" already deleted");
			}
			
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
