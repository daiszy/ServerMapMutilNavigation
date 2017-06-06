package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import Service.GetAsignedOrderByTelService;
import Service.WebGetAsignedOrdersService;

public class GetAsignedOrderByTelServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	    response.setHeader("Access-Control-Allow-Origin","*");
			
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		
		String tel = request.getParameter("telphone");
		
		GetAsignedOrderByTelService getAsignedOrderService = new GetAsignedOrderByTelService();		
		lists = getAsignedOrderService.getAsignedOrdersByTel(tel);
		//将list集合封装成json类型的数据
		JSONArray jsonArray = JSONArray.fromObject(lists);
				
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(jsonArray.toString());
		}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
	    response.setHeader("Access-Control-Allow-Origin","*");
			
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		
		String tel = request.getParameter("telphone");
		
		GetAsignedOrderByTelService getAsignedOrderService = new GetAsignedOrderByTelService();		
		lists = getAsignedOrderService.getAsignedOrdersByTel(tel);
		//将list集合封装成json类型的数据
		JSONArray jsonArray = JSONArray.fromObject(lists);
				
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(jsonArray.toString());
		}
}
