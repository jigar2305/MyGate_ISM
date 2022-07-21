package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	static String driver = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5432/MyGate";
	static String userName = "postgres";
	static String password = "128128";

	public static void main(String[] args) {
		Dbconnection.getConnection();
	}

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, userName, password);

			return con;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
