package com.timer.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	public String MySQLLink = "";
	public Connection Connection;
	private Statement Statement;
	
	public void Start(String Host, String User, String Pass, String Database)
	{
		try
		{
		 Class.forName("com.mysql.jdbc.Driver");

         MySQLLink = "jdbc:mysql://" + Host + "/" + Database;
         Connection = DriverManager.getConnection(
                 MySQLLink,
                 User,
                 Pass
                 );
         Statement = Connection.createStatement();
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet GetRow(String Query)
	{
		try {
			// Get one value
			ResultSet set = Statement.executeQuery(Query);
			
			while (set.next())
				return set;
			
			return set;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet GetTable(String Query)
	{
		try
		{
			return Statement.executeQuery(Query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public String GetString(String Query, String Row)
	{
		try
		{
			return (Statement.executeQuery(Query)).getString(Row);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public int GetInt(String Query, String Row)
	{
		try
		{
			return (Statement.executeQuery(Query)).getInt(Row);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
}
