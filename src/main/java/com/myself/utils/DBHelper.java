package com.myself.utils;
import com.mysql.jdbc.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class DBHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/world";
	private static String user = "root", password = "root123";
    private static com.mysql.jdbc.Connection con;
	//private static ResultSet result;
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public  void closeConnection(){
		try {
			if(con!=null&&!con.isClosed())
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public com.mysql.jdbc.Connection getCon() {
		return con;
	}

    public  ResultSet query(String sql){
    	ResultSet rs=null;
    	try {
			con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);
			com.mysql.jdbc.Statement cmd = (com.mysql.jdbc.Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				    ResultSet.CONCUR_UPDATABLE);
			rs=cmd.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	return rs;
    }
    
	public  int Update(String sql) {
		int r = 0;
		try {
			com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);
			com.mysql.jdbc.Statement cmd = (com.mysql.jdbc.Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				    ResultSet.CONCUR_UPDATABLE);
			r = cmd.executeUpdate(sql);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
}