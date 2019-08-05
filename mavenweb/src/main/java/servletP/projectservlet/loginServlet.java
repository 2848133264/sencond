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

		//��֤��Ϣ
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		//�жϲ�Ϊ�յ����
		if(username!=null && password!=null){
			System.out.println("username ="+username+"\tpassword = "+password);
			//���������Ϊ�յ�����£���ֱ��ǰȥ�ж�ʱ�������ݿ�����û��
			User user = new User(username, password);
						
			try {
				if(daoImpl.login(user)){
					//���ص���true �Ļ��ͽ��в�������
					//
					request.getSession().setAttribute("username", username);
					request.getSession().setAttribute("user", user);
					request.getServletContext().setAttribute("usera", user);
					response.sendRedirect("/mavenweb/Project/home.jsp");
					
				}else {
					//û���ҵ�������£����ص������
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
