package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.WebDeleteOrdersService;
import Service.WebDeleteUserService;

public class WebDeleteUserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		//接收客户端信息
		String telphone = request.getParameter("telphone");
			
		//新建服务对象
		WebDeleteUserService deleteService = new WebDeleteUserService();
		boolean isTrue = deleteService.deleteOrders(telphone);

		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
		
	}
}
