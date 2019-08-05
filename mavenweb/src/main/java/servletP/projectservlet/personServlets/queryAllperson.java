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
 * Servlet implementation class queryAllperson
 */
@WebServlet("/queryAllP.do")
public class queryAllperson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//查询所有的遍历结果
		
		persondaoImpl perimpl =new persondaoImpl();
		
		try {
			List<person> list= perimpl.personQuery();
			if(list!=null){
				//说明存在结果集
				//放到这个设置里边去，session范围？request 范围呢，我选择session数据,出现问题，就是信息不会消失
				request.getSession().setAttribute("personlist", list);
				response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
			}else {
				System.out.println("数据为空，不想传！");
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
