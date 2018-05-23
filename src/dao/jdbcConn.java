package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class jdbcConn {
	public static Env env=Env.getInstance();
	private static String driver = env.getProperty("driver");
	private static String url = env.getProperty("url");
	private static String user=env.getProperty("user");
	private static String pwd =env.getProperty("root");
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static Statement st=null;
	static{
		try {
			//��һ��:ע������
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			//�ڶ�������������
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
}
