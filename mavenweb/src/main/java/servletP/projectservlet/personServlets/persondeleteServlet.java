package servletP.projectservlet.personServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityP.person.person;
import EntityP.person.dao.persondaoImpl;

/**
 * Servlet implementation class persondeleteServlet
 */
@WebServlet("/persondelete.do")
public class persondeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//查询所有的病历单
		persondaoImpl u= new persondaoImpl();
		try {
			List<person> list = u.personQuery();
			if(list!=null&&list.size()>0){
				request.setAttribute("personlist", list);
				request.getRequestDispatcher("/Project/person/persondelete.jsp").forward(request, response);
				return ;
			}
			else{
				System.out.println("查询数据失败！");
			}
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
