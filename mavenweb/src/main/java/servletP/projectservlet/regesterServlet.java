package servletP.projectservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.impl.UserDaoImpl;
import EntityP.User;

@WebServlet("/regester.do")
public class regesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//用户注册的servlet
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		User user= new User(username,password);
		if(username!=null&&password!=null){
			UserDaoImpl userDaoImpl =new UserDaoImpl();
			try {
				if(userDaoImpl.regester(user)){
					System.out.println("用户注册成功！");
					//跳转到登入界面去。
					request.getRequestDispatcher("/Project/htmlF/login.jsp").forward(request, response);
				}else {
					System.out.println("用户注册失败！");
				
					response.sendRedirect("/mavenweb/Project/htmlF/regester.jsp");
				};
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
