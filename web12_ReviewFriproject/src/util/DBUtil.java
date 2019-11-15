package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	static DataSource ds;
	static {
		//1. InitialContext 객체 생성
		try {
			InitialContext ic = new InitialContext();
			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			//어캐 찾아오는거고 머 외부 바인딩으로 찾아온다함..?
			System.out.println("DataSource Lookup..Success..");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup..Fail..");
		}
		
		//2. lookup으로 DataSource를 찾아온다 Naming Service
		
		
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void close(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt) {
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void close(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
}







