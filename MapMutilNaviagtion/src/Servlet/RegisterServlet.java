package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.GetUserInfoService;
import Service.RegisterService;

public class RegisterServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String nickName = request.getParameter("nickName");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String telphone = request.getParameter("telphone");
		String ofCity = request.getParameter("ofCity");
		String password = request.getParameter("password");
		nickName = new String(nickName.getBytes("ISO-8859-1"),"UTF-8");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		sex = new String(sex.getBytes("ISO-8859-1"),"UTF-8");
		telphone = new String(telphone.getBytes("ISO-8859-1"),"UTF-8");
		ofCity = new String(ofCity.getBytes("ISO-8859-1"),"UTF-8");
		password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
		
		//新建服务对象
		RegisterService registerService = new RegisterService();
		boolean isTrue = registerService.register(nickName,name,sex,telphone,ofCity,password);

		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String nickName = request.getParameter("nickName");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String telphone = request.getParameter("telphone");
		String ofCity = request.getParameter("ofCity");
		String password = request.getParameter("password");
			
		//新建服务对象
		RegisterService registerService = new RegisterService();
		boolean isTrue = registerService.register(nickName,name,sex,telphone,ofCity,password);

		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
		
	}
}
