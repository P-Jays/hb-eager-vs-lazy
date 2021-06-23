package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Course;
import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int id = 1;
			
			System.out.println("Creating courses ");
			
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			Course course1 = new Course("my first course");
			
			Course course2 = new Course("my second course");
			
			tempInstructor.add(course1);
			
			tempInstructor.add(course2);
			
			session.save(course1);
			
			session.save(course2);
			
			// System.out.println("\n"+tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
