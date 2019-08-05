package mavenweb;

import java.sql.Connection;

import mavenweb.DBUtil.c3p0_DBUtils;

public class Test_c3p0 {
	public static void main(String[] args) throws Exception {
		
		Connection conn = c3p0_DBUtils.getConnection();
		System.out.println(conn.getCatalog());
	}

}
