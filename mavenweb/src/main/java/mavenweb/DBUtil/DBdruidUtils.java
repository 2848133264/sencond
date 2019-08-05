package mavenweb.DBUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DBdruidUtils {
	
	/*
	 * 	这个类提供数据库的连接、关闭
	 */
	private static Connection con=null;//连接
	
	private static Properties pro=new Properties();//加载属性文件
	
	private static InputStream inputStream = DBdruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
    
	// private static ThreadLocal<Connection> connectionPool = new
	// ThreadLocal<Connection>();
	public static Connection getConnection() throws Exception {
		// 获得连接池得对象

		pro.load(inputStream);
		DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
		// 获得连接
		if (con == null) {
			con = dataSource.getConnection();
			// System.out.println("一开始是没有con连接的");
		}
		System.out.println("初始化成功");
		return con;
	}
	public static void closeAll(Connection con,PreparedStatement pstm,ResultSet rs) throws SQLException {
		
		if(rs!=null) {
			rs.close();
		}if(pstm!=null) {
			pstm.close();
		}if(con!=null) {
			con.close();
		}
		System.out.println("已关闭连接.....");
	}

}
