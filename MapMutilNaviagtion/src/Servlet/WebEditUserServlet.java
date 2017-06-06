package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.WebEditOrdersService;
import Service.WebEditUserService;

public class WebEditUserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Access-Control-Allow-Origin","*");
		
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String telphone = request.getParameter("telphone");
		//sendTime = new String(sendTime.getBytes("ISO-8859-1"),"UTF-8");
		String grade = request.getParameter("grade");
		String ofCity = request.getParameter("ofCity");
		//detail = new String(detail.getBytes("ISO-8859-1"),"UTF-8");
		
		WebEditUserService editService = new WebEditUserService();
		boolean is = editService.editOrders(name, sex, telphone, grade,ofCity);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(is);
	}
}
