package com.revature.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DriverManager
//Connection
//Statement
//ResultSet

public class JDBC {
	public static void main(String[] args) {
		String q = "SELECT * FROM associates";
		Connection conn =null;
		Statement stmt=null;
		ResultSet set=null;
		/*
		 * launchctl setenv "db_url" "jdbc:postgresql://revature-training.cm0qbcmdvszr.us-east-2.rds.amazonaws.com:5432/postgres", 
			launchctl setenv "db_user" "postgres", 
					
		 */
		String url = System.getenv("db_url");
		String user = System.getenv("db_user");
		String password = System.getenv("db_password");
		try {
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			set = stmt.executeQuery(q);
			
			while(set.next()) {
				String name = set.getString(1);
				boolean numberi = set.getBoolean(2);
				String place = set.getString(3);
				int id = set.getInt(4);
				
				System.out.println(name+", "+numberi+ ", "+ place + ", "+ id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
