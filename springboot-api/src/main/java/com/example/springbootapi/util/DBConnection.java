package com.example.springbootapi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBConnection
{
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/EmployeeApi";
	private static final String USER_NAME = "postgres";
	private static final String DB_PASSWORD = "Akhil@123ct";
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static Connection con = null;

	private DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(CONNECTION_URL, USER_NAME, DB_PASSWORD);
	}

	public static Connection getConnection() throws SQLException
	{
		return con;
	}

}
