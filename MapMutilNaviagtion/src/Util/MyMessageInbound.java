package Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Date;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import Info.MessCenter;


/**消息入口类*/
public class MyMessageInbound extends MessageInbound{

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTextMessage(CharBuffer msg) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Received:"+msg);
		MessCenter.getInstance().broadcast(msg);
	}

	protected void onClose(int status) {
		System.out.println("close:"+new Date());
		MessCenter.getInstance().removeMessInbound(this);
		super.onClose(status);
	}
	
	protected void onOpen(WsOutbound outbound) {
		System.out.println("open:"+new Date());
		super.onOpen(outbound);
		MessCenter.getInstance().addMessInbound(this);
	}
}
