package com.bizviz.ccat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	volatile private static DBConnection connection;
	private Connection dbConn;
	private Statement stat;
	private DBConnection(){
		Properties prop = new Properties();
		//prop.load(inStream);
		String dbURl = prop.getProperty("dbUrl");
		String driver = prop.getProperty("db_driver");
		String dbPasswd = prop.getProperty("db_pass", "root");
		String dbUser = prop.getProperty("db_user", "root");
		try {
			Class.forName(driver).newInstance();
			this.dbConn = DriverManager.getConnection(dbURl, dbUser, dbPasswd);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static DBConnection createInstance(){
		if(connection == null){
			synchronized (connection) {
				if (connection == null) {
					connection = new DBConnection();							
				}
			}
		}
		return connection;
	}
	
	public Connection getConnection() {
		createInstance();
		return connection.dbConn;
	}
	
	public ResultSet query(String query) throws SQLException{
        stat = connection.dbConn.createStatement();
        ResultSet res = stat.executeQuery(query);
        return res;
    }
	
	public int insert(String insertQuery) throws SQLException {
        stat = connection.dbConn.createStatement();
        int result = stat.executeUpdate(insertQuery);
        return result;
 
    }
}
