package com.doubletrouble.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	
	public static Connection getConnectionProp()  throws IOException, SQLException {
		/*Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,user,password);
		*/
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","superuser","p4ssw0rd");
	}
}
