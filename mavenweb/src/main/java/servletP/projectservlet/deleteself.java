package servletP.projectservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import DAO.impl.UserDaoImpl;
import EntityP.User;

/**
 * Servlet implementation class deleteself
 */
@WebServlet("/deleteself.do")
public class deleteself extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //admin-123-
		User user  = (User) request.getSession().getAttribute("user");
		User sUser =(User) request.getServletContext().getAttribute("usea");
		System.out.println(sUser);
		System.out.println(user.getUsername()+"," +user.getPassword());
		
		UserDaoImpl u =new UserDaoImpl();
		try {
			if(u.delect(user)){
				System.err.println("删除成功");
				//重新跳转到登入页面
				request.getSession().invalidate();
				response.sendRedirect("/mavenweb/Project/htmlF/login.jsp");
			}else{
				System.out.println("注销用户失败！");
				response.sendRedirect("/mavenweb/Project/home.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
