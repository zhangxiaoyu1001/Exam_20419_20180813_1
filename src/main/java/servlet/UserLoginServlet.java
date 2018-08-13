package servlet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* @author BieHongLi 
* @version 创建时间：2017年2月21日 上午10:49:44 
* 
*/
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user=new User();
		//获取login.jsp页面提交的账号
		String name=request.getParameter("firstName");

		//测试数据
		/*System.out.println(name);
		System.out.println(actorId);*/
		//获取login.jsp页面提交的账号和密码设置到实体类User中
		user.setFirstName(name);


		//引入数据交互层
		UserDao dao=new UserDaoImpl();
		User us=dao.login(user);
		//测试返回的值
		System.out.println(us);
		HttpSession session=request.getSession();
		if(us!=null){

			session.setAttribute("sucess", "登陆成功！");
			session.setAttribute("flag","success");
			request.getRequestDispatcher("Film").forward(request, response);
		}else{

			request.setAttribute("message", "登陆失败！");
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		

	}

}
