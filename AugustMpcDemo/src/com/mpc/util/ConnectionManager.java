package com.mpc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionManager implements DBConnectionUtil {

	Connection con=null;
	
	public Connection getConnection()throws ClassNotFoundException, SQLException 
	{
			
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/augustdb", "root","");
		if(!con.isClosed())
		{
			System.out.println("Connection successful....!!!");
		}
		return con;
		
   }

	@Override
	public void closeConnection() throws SQLException 
	{
		if(con!=null)
		con.close();
	}
	
	}




