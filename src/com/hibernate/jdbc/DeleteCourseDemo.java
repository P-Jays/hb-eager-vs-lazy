package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Course;
import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int id = 10;
			
			System.out.println("delete instructor courses ");
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			if(course!= null) {
				session.delete(course);
			}
			
			
			
			// System.out.println("\n"+tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
