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
 * Servlet implementation class searchResult
 */
@WebServlet("/searchR.do")
public class searchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//根据传过来的id进行数据的查询。
		String id = request.getParameter("searchid_card");
		System.out.println("searchResult..."+id);
		//处理传过来的数据
		//1.不能为空，符合这个输入的数字类型
		String regex ="^1[0-9]{2}";//病历号不能为三位数 000，纯数字
		String regexidCard ="^[1-9][0-9]{6}";//身份证号不能低于6位数字
		
		if(id.matches(regex)){
			
			//查询数据
			persondaoImpl p =new persondaoImpl();
			int idi =Integer.parseInt(id);
			try {
				List<person> list = p.personQuery(idi);
				if(list!=null&&list.size()> 0){
					request.getSession().setAttribute("searchResult", list);
					//跳转到显示界面
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}else{
					//没有获取数据,
					System.out.println("没有查询到数据");
					/*request.setAttribute("errorMsg", "没有查询到数据");*/
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(id.matches(regexidCard)){
			
			//查询数据
			persondaoImpl p =new persondaoImpl();
			try {
				List<person> list = p.personQuery(id);
				if(list!=null&&list.size()> 0){
					request.getSession().setAttribute("searchResult", list);
					//跳转到显示界面
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}else{
					//没有获取数据,
					System.out.println("没有查询到数据");
					/*request.setAttribute("errorMsg", "没有查询到数据");*/
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
		     	System.out.println("输入不合法！");
			/*	request.setAttribute("errorMsg", "输入不合法！");*/
				response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
				return;
		}
		
/*		if(id.matches(regex) || id.matches(regexidCard) ){	
			//查询数据
			persondaoImpl p =new persondaoImpl();
			try {
				List<person> list = p.personQuery(id);
				if(list!=null&&list.size()> 0){
					request.getSession().setAttribute("searchResult", list);
					//跳转到显示界面
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}else{
					//没有获取数据,
					System.out.println("没有查询到数据");
					request.setAttribute("errorMsg", "没有查询到数据");
					response.sendRedirect("/mavenweb/Project/person/queryPerson.jsp");
					return ;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
