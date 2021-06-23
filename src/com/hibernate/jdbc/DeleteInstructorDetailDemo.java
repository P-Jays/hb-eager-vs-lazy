package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int id = 3;
			// instructor detail id
			
			
			session.beginTransaction();
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("\n"+tempInstructorDetail.getInstructor());
			
			System.out.println("\nDeleting Instructor Detail only"+tempInstructorDetail);
			
			// for deleting only instructor detail must set the instructor detail to null first
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// after that we cam use this code
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
