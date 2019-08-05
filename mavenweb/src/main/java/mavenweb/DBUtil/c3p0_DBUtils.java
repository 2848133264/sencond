package mavenweb.DBUtil;

import java.sql.Connection;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0_DBUtils {

	/**
	 * c3p0 方式连接数据库。
	 * 
	 * @author 李祖林 2019/7/24
	 */
	// 数据库连接池
	private static DataSource dataSource = new ComboPooledDataSource();
	// 线程槽：用于维持线程内的Connection对象
	private static ThreadLocal<Connection> connectionPool = new ThreadLocal<Connection>();

	public static Connection getConnection() throws Exception {
		// 从线程槽用获取线程内的连接对象
		Connection con = connectionPool.get();
		// 如果连接对象为null，表示该线程中还没有创建连接对象
		// 则从连接池中获取一个连接对象，并置入线程槽
		if (con == null) {
			con = dataSource.getConnection();
			connectionPool.set(con);
		}
		System.out.println("获得数据库连接对象！");
		return con;
	}

	public static void close() throws Exception {
		Connection con = connectionPool.get();
		if (con != null) {
			con.close();
			connectionPool.remove();
		}
	}

}
