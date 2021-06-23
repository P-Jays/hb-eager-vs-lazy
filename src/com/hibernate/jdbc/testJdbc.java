package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJdbc {

	public static void main(String[] args) {
		
		//String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String username = "hbstudent";
		String password = "hbstudent";		
		try {
			System.out.println(" connecting to database:"+ jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println(" connection successful to database:"+ jdbcUrl);
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
