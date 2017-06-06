//package Servlet;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.catalina.websocket.MyMessageInbound;
//import org.apache.catalina.websocket.StreamInbound;
//import org.apache.catalina.websocket.WebSocketServlet;
//
//public class MyWebSocketServlet extends WebSocketServlet{
//
//	private static final long serialVersionUID = -7178893327801338294L;
//	@Override
//	protected StreamInbound createWebSocketInbound(String subProtocol,
//			HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		System.out.println("***client login***");
//		return new MyMessageInbound();
//	}
//
//}
