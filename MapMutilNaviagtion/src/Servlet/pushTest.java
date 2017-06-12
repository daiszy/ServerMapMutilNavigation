package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import push.PushMsgToAll;
import Service.LoginService;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

public class pushTest extends HttpServlet{

//	public void doGet(HttpServletRequest request,HttpServletResponse response) 
//			throws ServletException,IOException{
//		System.out.print("into push");
//		PushMsgToAll pushMsg = new PushMsgToAll();
//		try {
//			pushMsg.pushMsgToAll("hh");
//		} catch (PushClientException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (PushServerException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}		
}
