package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Course;
import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class EagerLazyDemo {

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
			
			// we can set the lazy or eager loading at Instructor at line @OneToMany 
			Instructor tempInstructor = session.get(Instructor.class, id);
			// because of eager loading, in at this line everything is loaded(instructor, instructor detail, courses)
			// and save it in memory
			// so for print the data, no need to hit the database anymore
			// but usually we tend to use lazy loading
			
			 System.out.println("\n"+tempInstructor);
			// if we use lazy loading this line still not fetch Courses
			
			System.out.println("\n"+tempInstructor.getCourses());
			// using lazy loading , it will fetch course if we need it
			
			session.getTransaction().commit();
			
			// if we want to fetch the course data when the session is close (lazy loading)
			// option 1: we can fetch it if we getCourse when the session still open
			// option 2: in Fetch join demo
			session.close();
			
			System.out.println("session close");
			
			// so we still can get the course 
			System.out.println("\n"+tempInstructor.getCourses());
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
