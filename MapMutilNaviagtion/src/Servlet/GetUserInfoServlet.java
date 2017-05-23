package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Info.UserInfo;
import Service.GetUserInfoService;
import Util.JSONTools;
import Util.UserInfoUtil;

public class GetUserInfoServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//接收客户端信息
		String username = request.getParameter("username");
	 
		System.out.println(username);
		
		//新建服务对象
		GetUserInfoService getUserInfoService = new GetUserInfoService();
		Map<String,Object> map= new HashMap<String, Object>();
		map = getUserInfoService.getUserInfo(username);
		
		UserInfo userInfo = new UserInfo(map.get("nickName").toString(),map.get("name").toString(),map.get("sex").toString(),map.get("telphone").toString(),map.get("ofCity").toString());
		UserInfoUtil userInfoUtil = new UserInfoUtil();
		List<Map<String,Object>> lists = userInfoUtil.getMaps();
		
//		JSONTools jsonTools = new JSONTools();
//		String jString;
//		jString = jsonTools.createJsonString("nickName", value);
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(lists);
//		writer.print(map.get("nickName"));
//		writer.print(map.get("name"));
//		writer.print(map.get("sex"));
//		writer.print(map.get("telphone"));
//		writer.print(map.get("ofCity"));
	  }
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	//接收客户端信息
	String username = request.getParameter("username");
 
	System.out.println(username);
	
	//新建服务对象
	GetUserInfoService getUserInfoService = new GetUserInfoService();
	Map<String,Object> map= new HashMap<String, Object>();
	map = getUserInfoService.getUserInfo(username);
	
	UserInfo userInfo = new UserInfo(map.get("nickName").toString(),map.get("name").toString(),map.get("sex").toString(),map.get("telphone").toString(),map.get("ofCity").toString());
	UserInfoUtil userInfoUtil = new UserInfoUtil();
	List<Map<String,Object>> lists = userInfoUtil.getMaps();
	
	//返回信息到客户端
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");
	PrintWriter writer = response.getWriter();
	writer.print(lists);
//	writer.print(map.get("nickName"));
//	writer.print(map.get("name"));
//	writer.print(map.get("sex"));
//	writer.print(map.get("telphone"));
//	writer.print(map.get("ofCity"));
  }
}