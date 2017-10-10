package kr.or.dgit.jdbc_setting.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCon {
	private static final DBcon instance = new DBCon();
	private Connection connection;
	
	private DBCon(){
		Properties properties = getProperties("conf.properties");
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("pwd"));
		System.out.println(properties.getProperty("url"));
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
