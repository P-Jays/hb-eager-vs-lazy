package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			Instructor tempInstructor = new Instructor("PJ","Prajanwi","goldprajnawi@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com","Learning");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			System.out.println("Creating new object.. ");
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			System.out.println("\n"+tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
