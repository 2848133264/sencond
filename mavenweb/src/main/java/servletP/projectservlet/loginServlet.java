package servletP.projectservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.impl.UserDaoImpl;
import EntityP.User;


@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl daoImpl =new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//验证信息
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		//判断不为空的情况
		if(username!=null && password!=null){
			System.out.println("username ="+username+"\tpassword = "+password);
			//符合这个不为空的情况下，就直接前去判断时候在数据库中有没有
			User user = new User(username, password);
						
			try {
				if(daoImpl.login(user)){
					//返回的是true 的话就进行操作界面
					//
					request.getSession().setAttribute("username", username);
					request.getSession().setAttribute("user", user);
					request.getServletContext().setAttribute("usera", user);
					response.sendRedirect("/mavenweb/Project/home.jsp");
					
				}else {
					//没有找到的情况下，返回登入界面
					response.sendRedirect("/mavenweb/Project/htmlF/login.jsp");
				};
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
