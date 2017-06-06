package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.RegisterService;
import Service.WebDeleteOrdersService;

public class WebDeleteOrdersServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		//接收客户端信息
		String orderId = request.getParameter("orderId");
			
		//新建服务对象
		WebDeleteOrdersService deleteService = new WebDeleteOrdersService();
		boolean isTrue = deleteService.deleteOrders(orderId);

		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
		
	}
}
