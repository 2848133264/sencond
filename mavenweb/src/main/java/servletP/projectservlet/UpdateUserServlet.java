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
	
		//��������Ĳ���
		/**
		 * ͨ��updateuser.jsp ������е����ݣ��������ݵĸ���
		 * �������֮�����ת����ҳ������ҳ���ǵ�������أ����������ǻص���ҳ��ȥ���´εĵ����ʹ��������
		 */
		//String username =request.getSession().get;
		//response.getWriter().write("hello");
		//��ñ��е�����
		String username =(String) request.getSession().getAttribute("username");
		System.out.println("username: "+username);
		String oldpassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		//1.һ���������������Ƿ�����ڵ��û����������Ƿ���ͬ�������ͬ���������ʾ��
		System.out.println(username+" ,"+oldpassword+", "+newPassword);
		UserDaoImpl userDaoImpl =new UserDaoImpl();
		try {
			List<User> list = userDaoImpl.QueryAllUser();
			//�������list ���ҳ����username ��Ӧ������
				for (User user : list) {
					if(user.getPassword().equals(oldpassword) && (newPassword!=null&&!" ".equals(newPassword))){
						//���������ͬ�Ļ���������һ������
						//2.�����ͬ�Ļ����ͽ������ж�������������Ƿ�Ϊ�ա���Ϊ�����ִ���޸�������ݿ��е�����		
							if(userDaoImpl.Updateuser(user, newPassword)){
								System.out.println("�����޸ĳɹ�");
								//���ص���ҳ��ȥ
								response.sendRedirect("/mavenweb/Project/home.jsp");
								return;
							}else{
								System.out.println("�����޸Ĵ���");						
							}					
						}							
				}
				//�˻ص�����޸Ľ���
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
