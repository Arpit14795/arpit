package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager implements DBConnectionUtil 
{
	private Connection con;
	@Override
	public Connection getConnection() 
	{
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/questiondb", "root", "root"	);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		return con;
	}
	
	@Override
	public void closeConnection() 
	{
	try {
		if(!con.isClosed() && con!=null)
			con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


}
