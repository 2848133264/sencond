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
 * Servlet implementation class searchid
 */
@WebServlet("/search_id.do")
public class searchid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String idString=request.getParameter("id");
		int id = Integer.parseInt(idString);
		persondaoImpl u =new persondaoImpl();
		try {
			List<person> list = u.personQuery(id);
			if(list!=null&&list.size()>0){
				//将数据传到这个查询界面
				request.getSession().setAttribute("searchResult", list);
				//跳转到显示界面
				response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
				return ;
			}else{
				
				//获取数据失败！，同样显示操作界面
				response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
				return ;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
