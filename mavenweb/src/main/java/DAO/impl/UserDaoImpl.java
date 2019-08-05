package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.UserDao;
import EntityP.User;
import mavenweb.DBUtil.c3p0_DBUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(User user) throws Exception {
		// TODO Auto-generated method stub
		//连接数据库，查找是否含有这个穿过来的user的 username，password。
		boolean flag = false;
		
		//穿过来的数据跟数据库中的数据进行比对
		//连接数据库,采用druidUtils 的工具类进行数据库的连接
		Connection con =c3p0_DBUtils.getConnection();
		//准备SQL语句,采用预编译的方式，只对用户名跟密码进行选择
		String sql ="select username,password from user";
		PreparedStatement pstm =con.prepareStatement(sql);
		ResultSet rsSet =pstm.executeQuery();
		while (rsSet.next()) {
			//只有两列，所以就是1,2
			String username =rsSet.getString(1);
			String password =rsSet.getString(2);
			if(username.equals(user.getUsername()) &&password.equals(user.getPassword())){
				//匹配成功之后，返回这个flag = true
				flag =true;
			}
		}
		//c3p0_DBUtils.closeAll(con, pstm, null);
		return flag;
	}

	@Override
	public boolean regester(User user) throws Exception {
		// TODO Auto-generated method stub
		//从servlet中穿过来的这个数据，不用再去验证了
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="insert into user(username,password) values(?,?)";
		//在这个方法中可以使用数据加密的方式，功能先放在一边    ******************
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		int num =pstm.executeUpdate();
		if(num>0){
			c3p0_DBUtils.close();
			return true;
		}else {
			//c3p0_DBUtils.closeAll(conn, pstm, null);
			return false;
		}
		
	}

	@Override
	public boolean Updateuser(User user, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		
		//只做更新密码的操作
		/**
		 * 此功能只能是在用户登入的情况下使用，就是已知user的信息
		 * 要不要写出原密码，跟确定密码的操作？省略。
		 * 
		 */
		Connection conn =c3p0_DBUtils.getConnection();
		String sql ="update user set password=? where username = ?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setString(1, newPassword);
		pstm.setString(2, user.getUsername());
		int num =pstm.executeUpdate();
		if(num > 0){
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public List<User> QueryAllUser() throws Exception{
		// TODO Auto-generated method stub
		//查询这个User表中的所有数据返回一个List集合
		List<User> list =new ArrayList<User>();
		Connection conn = c3p0_DBUtils.getConnection();
		String sql = "select * FROM user";
		PreparedStatement pstm =conn.prepareStatement(sql);
		//接收数据
		ResultSet rsSet =pstm.executeQuery();
		
		while(rsSet.next()){
			int id = rsSet.getInt(1);
			String username =rsSet.getString(2);
			String password = rsSet.getString(3);
			
			User user =new User(id,username, password);
			list.add(user);
		}
		//c3p0_DBUtils.closeAll(conn, pstm, rsSet);
		return list;
	}

	@Override
	public boolean delect(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = c3p0_DBUtils.getConnection();
		//采用预编译的方式
		String sql ="delete from user where username=? and password=?";
		PreparedStatement pstm =conn.prepareStatement(sql);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		int num =pstm.executeUpdate();
		if(num>0){
			return true;
		}else{
			return false;
		}
	}

}
