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
import Info.UserInfo;
import Service.GetUserInfoService; 
import Service.WebGetOrdersDetailByIdService;
import Util.UserInfoUtil;

//根据订单编号获取订单详细信息
public class WebGetOrdersDetailByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setHeader("Access-Control-Allow-Origin","*");
			
		//接收客户端信息
		String orderId = request.getParameter("orderId");
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		Map<String,Object> map= new HashMap<String, Object>();
		
		//新建服务对象
		WebGetOrdersDetailByIdService getOrderByIdService = new WebGetOrdersDetailByIdService();
		lists = getOrderByIdService.getOrdersDetail(orderId);
			
		//将list集合封装成json类型的数据
		JSONArray jsonArray = JSONArray.fromObject(lists);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(jsonArray);
	}
}
