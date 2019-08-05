package servletP.projectservlet.personServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EntityP.person.person;
import EntityP.person.dao.persondaoImpl;

@WebServlet("/personadd.do")
public class personADDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  idString =request.getParameter("id");
		String  name =request.getParameter("personname");
		String  age =request.getParameter("age");
		String gender =request.getParameter("sex");
		/*System.out.println(sex);*/
		String isMarray =request.getParameter("isMarry");
		String inDate =request.getParameter("inDate");
		/*System.out.println(inDate);*/
		String birthday =request.getParameter("birthday");
		String phone =request.getParameter("phone");
		String company =request.getParameter("company");
		String idCard =request.getParameter("idCard");
		String address =request.getParameter("address");
		String regex ="^1[0-9]{2}";//病历号保留三位数
		String regex2 ="^[1-9][0-9]{6}";//身份证号7位数,  2019001               查询功能要修改
		
		if(idString!=null&&name!=null&&gender!=null&&inDate!=null&&phone!=null&&idCard!=null){
			
			if("".equals(idString)||"".equals(gender)||
					"".equals(name)||"".equals(inDate)||"".equals(phone)||"".equals(idCard)){
				System.out.println("输入有误！");
				response.sendRedirect("/mavenweb/Project/person/personInsert.jsp");
				return;
			}else
			{
				//填写还算正确,正则表达式有错
				if(idString.matches(regex)&&idCard.matches(regex2)){
					//填写完成，所以进行添加操作
					persondaoImpl u =new persondaoImpl();
					int id =Integer.parseInt(idString);
					
					person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address,null,null,null);
					System.out.println(".."+isMarray);
					try {
						if(u.Personrecord(person)){
							//添加成功，则信息跳转。主界面吧
							response.getWriter().write("添加成功");
							response.sendRedirect("/mavenweb/Project/home.jsp");
							return ;
						}else {
							//添加失败跳转提示，继续跳到这个添加界面中去。
							response.getWriter().write("添加出错，3秒后跳转.........");
							response.setHeader("refresh", "3;url=/Project/person/personInsert.jsp");
							return;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}else {
			
			System.out.println("出错了！");
			return ;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
