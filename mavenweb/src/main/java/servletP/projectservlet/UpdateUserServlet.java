package servletP.projectservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.UserDaoImpl;
import EntityP.User;

@WebServlet("/updataUser.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//更新密码的操作
		/**
		 * 通过updateuser.jsp 这个表单中的数据，进行数据的更新
		 * 更新完成之后就跳转到首页，是首页还是登入界面呢？合理话，还是回到首页中去。下次的登入就使用新密码
		 */
		//String username =request.getSession().get;
		//response.getWriter().write("hello");
		//获得表单中的数据
		String username =(String) request.getSession().getAttribute("username");
		System.out.println("username: "+username);
		String oldpassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		//1.一般会想这个旧密码是否跟现在的用户名的密码是否相同，如果不同，则给出提示。
		System.out.println(username+" ,"+oldpassword+", "+newPassword);
		UserDaoImpl userDaoImpl =new UserDaoImpl();
		try {
			List<User> list = userDaoImpl.QueryAllUser();
			//遍历这个list 查找出这个username 对应的密码
				for (User user : list) {
					if(user.getPassword().equals(oldpassword) && (newPassword!=null&&!" ".equals(newPassword))){
						//如果密码相同的话，进行下一步操作
						//2.如果相同的话，就接下来判定输入的新密码是否不为空。不为空则就执行修改这个数据库中的数据		
							if(userDaoImpl.Updateuser(user, newPassword)){
								System.out.println("密码修改成功");
								//返回到首页中去
								response.sendRedirect("/mavenweb/Project/home.jsp");
								return;
							}else{
								System.out.println("密码修改错误！");						
							}					
						}							
				}
				//退回到这个修改界面
				response.sendRedirect("/mavenweb/Project/htmlF/updateuser.jsp");
				//request.getRequestDispatcher("/Project/htmlF/updateuser.jsp").forward(request, response);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
