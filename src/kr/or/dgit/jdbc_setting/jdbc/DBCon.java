package kr.or.dgit.jdbc_setting.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DBCon {
	private static final DBcon instance = new DBCon();
	private Connection connection;
	
	private DBCon(){
		Properties properties = getProperties("conf.properties");
		try{
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pwd"));
		} catch (SQLException e){
			System.err.println("%s - %s\n");
		}
		/*System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("pwd"));
		System.out.println(properties.getProperty("url"));*/
	}
	private Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		properties.load(is);
		return properties;
	}

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public static DBcon getInstance() {
		return instance;
	}
}
