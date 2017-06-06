package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.WebEditOrdersService;

public class WebEditOrdersServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Access-Control-Allow-Origin","*");
		
		String orderId = request.getParameter("orderId");
		String contactPhone = request.getParameter("contactPhone");
		String sendTime = request.getParameter("sendTime");
		//sendTime = new String(sendTime.getBytes("ISO-8859-1"),"UTF-8");
		String detail = request.getParameter("detail");
		//detail = new String(detail.getBytes("ISO-8859-1"),"UTF-8");
		
		WebEditOrdersService editService = new WebEditOrdersService();
		boolean is = editService.editOrders(orderId, contactPhone, sendTime, detail);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(is);
	}
	
}
