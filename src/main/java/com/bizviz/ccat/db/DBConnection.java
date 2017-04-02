package com.bizviz.ccat.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
		FileReader input = null;
		try {
			File fil = new File("./config.properties");
			//fil.createNewFile();
			System.out.println(fil.getAbsolutePath());
			//input = new FileReader(fil);
			prop.load(getClass().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// load a properties file
		
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
	
	public static DBConnection getInstance(){
		if(connection == null){
			synchronized (DBConnection.class) {
				if (connection == null) {
					connection = new DBConnection();							
				}
			}
		}
		return connection;
	}
	
	public Connection getConnection() {
		getInstance();
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
