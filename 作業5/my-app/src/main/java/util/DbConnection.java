package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static void main(String[]args) {
		System.out.println(DbConnection.getDb());
	}
	
	public static Connection getDb() {
		String url="jdbc:mysql://localhost:3306/hw5";
		String user="root";
		String password="1234";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				System.out.println("no connection");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		}
		return conn;
	}

}
