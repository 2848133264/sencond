package mavenweb;

import java.sql.SQLException;

import mavenweb.DBUtil.DBUtils;

public class Test_DBUtils {

	public static void main(String[] args) throws SQLException {
		java.sql.Connection con =DBUtils.getConnection();
		System.out.println(con);
		
	}
}
