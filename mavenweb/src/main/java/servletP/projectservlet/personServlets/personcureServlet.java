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


@WebServlet("/personcure.do")
public class personcureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString =request.getParameter("id");
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String bingshi =request.getParameter("bingshi");
		String xianzhuang =request.getParameter("xianzhuang");
		String result =request.getParameter("result");
		String inDate=request.getParameter("inDate");
		
		System.out.println(idString+name+age+bingshi+xianzhuang+result+inDate);
		/*
		 * 说明的是，获得数据不能为空，就算是简单的诊断也要写
		 * 病史可以没有，现状不能为空，诊断结果不能为空
		 */
		if(idString!=null&&name!=null&&age!=null
				&&xianzhuang!=null&&result!=null&&inDate!=null){
			
			if("".equals(idString)||
					"".equals(name)||
					 "".equals(age)||
					 "".equals(xianzhuang)||
					 "".equals(result)){
				System.out.println("填写有问题！");
				//返回诊断界面
				response.sendRedirect("/mavenweb/Project/person/personcure.jsp");
				return;
			}else {
				//数据都是正确的
				//还要对当前的病历号进行查询，数据库中是否存在这样的病历号
				int id =Integer.parseInt(idString);
				persondaoImpl u =new persondaoImpl();
				try {
					List<person> list = u.personQuery(id);//返回的就只有一个数据
					if(list!=null){
						//不为空则含有数据，则进行数据的保存。修改诊断内容
						person person =(person)list.get(0);
						//进行数据的更新：就诊时间、病史、现状、诊断结果
						System.out.println(person);//就诊时间
						person.setInDate(inDate);//病史
						person.setBingshi(bingshi);//现状
						person.setXianzhuang(xianzhuang);
						person.setResult(result);//诊断结果
						if(u.updatePersonMsg(person)){
							System.out.println("更新成功");
							//跳转到这个主页中
							response.sendRedirect("/mavenweb/Project/home.jsp");
							return;
						}
		
					}else{
						System.out.println("此病历号出错！无法进行保存");
						//跳转到这个就诊单中去
						response.sendRedirect("/mavenweb/Project/person/personcure.jsp");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
		}else{
			System.out.println("填写有错!!");
			//返回诊断界面
			response.sendRedirect("/mavenweb/Project/person/personcure.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
