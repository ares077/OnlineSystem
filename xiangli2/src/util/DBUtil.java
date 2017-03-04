package util;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil {
	private static BasicDataSource dataSource=null;
	public static void init(){
		Properties dbPros=new Properties();
		try {
			dbPros.load(DBUtil.class.getClassLoader().getResourceAsStream("util/mysql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String driverName=dbPros.getProperty("jdbc.driver");
			String url=dbPros.getProperty("jdbc.url");
			String user=dbPros.getProperty("jdbc.user");
			String password=dbPros.getProperty("jdbc.password");
			String initialSize=dbPros.getProperty("dataSource.initialSize");
			String minIdle=dbPros.getProperty("dataSource.minIdle");
			String maxIdle=dbPros.getProperty("dataSource.maxIdle");
			String maxWait=dbPros.getProperty("dataSource.maxWait");
			String maxActive=dbPros.getProperty("dataSource.maxActive");
			dataSource=new BasicDataSource();
			dataSource.setDriverClassName(driverName);
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			if (initialSize!=null) {
				dataSource.setInitialSize(Integer.parseInt(initialSize));
			}
			if (minIdle!=null) {
				dataSource.setMinIdle(Integer.parseInt(minIdle));
			}
			if (maxIdle!=null) {
				dataSource.setMaxIdle(Integer.parseInt(maxIdle));
			}
			if (maxWait!=null) {
				dataSource.setMaxWait(Long.parseLong(maxWait));
			}
			if (maxActive!=null) {
				if (!maxActive.trim().equals("0")) {
					dataSource.setMaxActive(Integer.parseInt(maxActive));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static synchronized Connection getConnection() throws Exception{
		if (dataSource==null) {
			init();
		}
		Connection connection=null;
		if (dataSource!=null) {
			connection=dataSource.getConnection();
		}
		return connection;
	}
	public static void close(Connection connection) throws Exception{
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
