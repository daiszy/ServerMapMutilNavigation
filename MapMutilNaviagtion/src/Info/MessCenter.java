package Info;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;


/**连接管理类*/
public class MessCenter {

	private static MessCenter instance = new MessCenter();
	private List<MessageInbound> socketList;
	
	private MessCenter(){
		this.socketList = new ArrayList<MessageInbound>();
	}
	
	public static MessCenter getInstance() {
		return instance;
	}
	
	public void addMessInbound(MessageInbound inbound) {
		socketList.add(inbound);
	}
	
	public void removeMessInbound(MessageInbound inbound) {
		socketList.remove(inbound);
	}
	
	public void broadcast(CharBuffer msg) throws IOException {
		for(MessageInbound messageInbound : socketList){
			CharBuffer buffer = CharBuffer.wrap(msg);
			WsOutbound outbound = messageInbound.getWsOutbound();
			outbound.writeTextMessage(CharBuffer.wrap("broadcasting"+msg));
			outbound.flush();
		}
	}
}
