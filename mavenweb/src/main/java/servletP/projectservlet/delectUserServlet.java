package servletP.projectservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.UserDaoImpl;
import EntityP.User;

/**
 * Servlet implementation class delectUserServlet
 */
@WebServlet("/delectUser.do")
public class delectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//应该有个id的属性，这样就比较容易删除数据，
		String  arry = request.getParameter("id");//这个是操作人的信息，不能删除
		//转成数组
		String arra [] =arry.split("-");
		User user =new User(arra[0],arra[1]);
		UserDaoImpl u =new UserDaoImpl();
		//删除这个值，
		//不能删除自己，先去判断删除的对象是否是自己，删除的对象
		User user2 =(User) request.getSession().getAttribute("user");
		
		//判断是不是自己
		if(user2.equals(user)){
			//不能执行此操作
			response.sendRedirect("/mavenweb/showUser.do");
		}else {
			try {
				if(u.delect(user)){
					//删除成功
					//返回到这个界面去
					System.out.println("删除成功");
					response.sendRedirect("/mavenweb/showUser.do");
				}else{
					System.out.println("删除失败");
					//返回到这个
					response.sendRedirect("/mavenweb/Project/htmlF/user.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
