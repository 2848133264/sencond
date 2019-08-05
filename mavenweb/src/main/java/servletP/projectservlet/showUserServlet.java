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

/**
 * Servlet implementation class showUserServlet
 */
@WebServlet("/showUser.do")
public class showUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//接收到查看数据的请求，则执行数据库的查询
				UserDaoImpl u = new UserDaoImpl();
				try {
					
					List<User> user=(List<User>)u.QueryAllUser();
					//封装在这个request中去
					request.setAttribute("userList", user);
					request.getRequestDispatcher("/Project/htmlF/user.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
