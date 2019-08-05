package servletP.projectservlet.personServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityP.person.person;
import EntityP.person.dao.persondaoImpl;

/**
 * Servlet implementation class personrecordPrintServlet
 */
@WebServlet("/printrecord.do")
public class personrecordPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String persons = request.getParameter("id");
		String personarry[] =persons.split(",");
		String  idstring =personarry[0];
		int id =Integer.parseInt(idstring);
		String  name =personarry[1];
		String  age =personarry[2];
		String gender =personarry[3];
		String isMarry =personarry[4];
		String inDate =personarry[5];
		String birthday =personarry[6];
		String company =personarry[7];
		String phone =personarry[8];
		String idCard =personarry[9];
		String address =personarry[10];
		String bingshi =personarry[11];
		String xianzhuang =personarry[12];
		String result =personarry[13];
/*	id + "," + name + "," + age + "," + gender + "," + isMarry
					+ "," + inDate + "," + birthday + "," + company + "," + phone
					+ "," + idCard + "," + address + "," + bingshi + "," + xianzhuang
					+ "," + result;
*/
		
		person person =new person(id, name, age, gender, isMarry, inDate, birthday, company, phone, idCard, address, bingshi, xianzhuang, result);
		persondaoImpl u =new persondaoImpl();
		
		try {
			if(u.printrecord(person)){
				System.out.println("模拟打印病历成功");
				
				response.sendRedirect("/mavenweb/Project/home.jsp");
			}else{
				response.getWriter().write("打印失败正在返回....");
				response.setHeader("refresh", "3;url=/mavenweb/Project/person/queryPerson.jsp");
			};
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
