package br.com.portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private Connection conn = null;
	
	public Connection getConnection(){
		
		String url_db    = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user_db   = "rm78317";
		String pass_db 	 = "280399";
		String driver_db = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver_db);
			this.conn = DriverManager.getConnection(url_db, user_db, pass_db);
			return this.conn;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
