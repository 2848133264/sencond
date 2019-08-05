package servletP.projectservlet.personServlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/personQuery")
public class personupdateQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//查询id的病历单
		
		persondaoImpl u= new persondaoImpl();
		PrintWriter out =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		try {
			List<person> list = u.personQuery(id);
			if(list!=null&&list.size()>0){
				out.write("true");
			}
			else{
				out.write("false");
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
