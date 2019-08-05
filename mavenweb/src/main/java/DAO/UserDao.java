package DAO;

import java.util.List;

import EntityP.User;

public interface UserDao{
	//可以实现这个登入功能,通过这个服务层传来的值。
	public boolean login(User user) throws Exception;
	public boolean regester(User user) throws Exception;
	public boolean Updateuser(User user,String newPassword) throws Exception;
	public List<User> QueryAllUser() throws Exception;
	public boolean delect(User user) throws Exception;
}
