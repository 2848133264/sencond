package mavenweb.DBUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	/**
	 * 连接数据库
	 * 
	 * @author 李祖林 2019/7/24
	 */

	// 连接操作（采用加载文件的方式)
	private static String Username = "";
	private static String Password = "";
	private static String driver = "";
	private static String Url = "";
	private static Connection conn;
	private static Properties properties;

	// 从jdbc文件中获取属性值
	private static void init() {

		driver = properties.getProperty("driver");
		Url = properties.getProperty("url");
		Username = properties.getProperty("username");
		Password = properties.getProperty("password");
		System.out.println(Username + Password);
	}

	// 采用静态的方式加载数据库文件
	static {

		properties = new Properties();
		try {

			InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("jdbcmaven.properties");
			properties.load(in);
			init();
			// 加载驱动类
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 创建连接操作
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(Url, Username, Password);
		return conn;
	}

	// 关闭操作
	public static void getCloseAll(PreparedStatement pstm, ResultSet rs, Connection con) throws Exception {

		// 判断连接是否为空
		if (rs != null) {
			rs.close();
		}
		if (pstm != null) {
			pstm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
