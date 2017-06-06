package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.recordMyLocationService;

public class recordMyLocationServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String telphone = request.getParameter("telphone");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		latitude = new String(latitude.getBytes("ISO-8859-1"),"UTF-8");
		longitude = new String(longitude.getBytes("ISO-8859-1"),"UTF-8");
		
		//新建服务对象
		recordMyLocationService recordService = new recordMyLocationService();
		boolean isTrue = recordService.recordLocation(telphone, latitude, longitude);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String telphone = request.getParameter("telphone");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		latitude = new String(latitude.getBytes("ISO-8859-1"),"UTF-8");
		longitude = new String(longitude.getBytes("ISO-8859-1"),"UTF-8");
		
		//新建服务对象
		recordMyLocationService recordService = new recordMyLocationService();
		boolean isTrue = recordService.recordLocation(telphone, latitude, longitude);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(isTrue);
	}
}
