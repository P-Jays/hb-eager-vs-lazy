package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.jdbc.demo.entity.Course;
import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class FetchJoinDemo {

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
			
			System.out.println("get instructor courses ");
			
			session.beginTransaction();

			// get instructor from db because it is join fetch , it use HQL to get Instructor also the course
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId", Instructor.class);
			
			// set query parameter
			query.setParameter("theInstructorId", id);
			
			// execute query and get Instructor
			Instructor tempInstructor = query.getSingleResult();
			
			 System.out.println("\n"+tempInstructor);
			// if we use lazy loading this line still not fetch Courses
		
			
			session.getTransaction().commit();
			
	
			session.close();
			
			System.out.println("session close");
			
			// so we still can get the course even the session is close
			System.out.println("\n"+tempInstructor.getCourses());
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
