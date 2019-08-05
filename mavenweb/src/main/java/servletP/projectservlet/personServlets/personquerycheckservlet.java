package servletP.projectservlet.personServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityP.person.person;
import EntityP.person.dao.persondaoImpl;

/**
 * Servlet implementation class personquerycheckservlet
 */
public class personquerycheckservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String ID = request.getParameter("personid");	
		System.out.println("用户名："+ID);
		String result ="";
		PrintWriter out =response.getWriter();
		
	
		persondaoImpl u =new persondaoImpl();

			if(ID!=null&&ID.matches("^1[0-9]{2}")){
				int id =Integer.parseInt(ID);//为空的情况
				try {
					List<person> list1 = u.personQuery(id);
					System.out.println(list1.size());//
					 if(list1.size() > 0){
						 out.write("true");
						  }else {
					   out.write("false");
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}else {
//				result ="false";
				 out.write("false");
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
