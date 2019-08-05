package mavenweb;

import java.sql.Connection;

import mavenweb.DBUtil.DBdruidUtils;

public class Test_druid {

	public static void main(String[] args) throws Exception {
		
		Connection conn =DBdruidUtils.getConnection();
		System.out.println(conn.getCatalog());
	}
}
