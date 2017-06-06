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

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import push.PushMsgToAll;
import net.sf.json.JSONArray;
import Service.GetUserInfoListService;
import Service.WebAsignedOrdersService;

public class WebAsignedOrdersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setHeader("Access-Control-Allow-Origin","*");
		
		String telphone = request.getParameter("username");
		
		WebAsignedOrdersService ordersService = new WebAsignedOrdersService();
		boolean b = ordersService.isAsigned(telphone);
		if(b)
		{
			PushMsgToAll pushMsg = new PushMsgToAll();
			try {
				pushMsg.pushMsgToAll(telphone);
			} catch (PushClientException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (PushServerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(b);
		
	}
}
