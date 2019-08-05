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
 * Servlet implementation class personUpdate
 */
@WebServlet("/personupdata.do")
public class personUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String  idString =request.getParameter("id");
		String  name=request.getParameter("name");
		String  gender =request.getParameter("sex");
		String  isMarry =request.getParameter("isMarry");
		String  phone =request.getParameter("phone");
		String  idCard =request.getParameter("idCard");
		String  xianzhuang =request.getParameter("xianzhuang");
		String  result =request.getParameter("result");
		/*System.out.println(result);*/
		persondaoImpl u =new persondaoImpl();
		if(idString!=null || name!=null||phone!=null||idCard!=null){
			int id =Integer.parseInt(idString);
			try {
				if(u.personQuery(id)!=null){
					//查询不为空则存在这个值，否则修改数据失败，返回到这个修改的界面中
					
					person person =new person(id,name, gender, isMarry, phone, idCard, xianzhuang, result);
					
					if(u.updatePerson(person)){
						
						System.out.println("病历修改成功");
						response.sendRedirect("/mavenweb/Project/home.jsp");
						return;
					};
				}else{
					response.sendRedirect("/Project/person/personupdateMsg.jsp");
					return;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
			response.sendRedirect("/Project/person/personupdateMsg.jsp");
			return;
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
