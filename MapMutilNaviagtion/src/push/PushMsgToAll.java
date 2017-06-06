package push;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.MsgSendInfo;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.QueryMsgStatusRequest;
import com.baidu.yun.push.model.QueryMsgStatusResponse;

public class PushMsgToAll {

	public static void pushMsgToAll(String args) throws PushClientException, PushServerException{
		
		System.out.println("into push");
		
		String apiKey = "pR1azYoXQBUKA0pyMkdcLrDlayN3TgVp";
		String secretKey = "04GFba2ElhfoaLALueDU0B5kLB7oEsv6";
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
		
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);
		
		pushClient.setChannelLogHandler (new YunLogHandler () {
		    @Override
		    public void onHandle (YunLogEvent event) {
		        System.out.println(event.getMessage());
		    }
		});
		
		try {
            // 4. specify request arguments
			PushMsgToAllRequest request = new PushMsgToAllRequest()
					.addMsgExpires(new Integer(3600))  //设置消息的有效时间,单位秒,默认3600*5.
					.addMessageType(1)  //设置消息类型,0表示透传消息,1表示通知,默认为0.
					.addMessage("{\"title\":\"订单产生\",\"description\":\"您有一条新的订单产生了!\"}")
					.addSendTime(System.currentTimeMillis() / 1000 + 65) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
					.addDeviceType(3);
            // 5. http request
            PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
            // Http请求返回值解析
            System.out.println("msgId: " + response.getMsgId() + ",sendTime: "    
                    + response.getSendTime() + ",timerId: "
                    + response.getTimerId());
        } catch (PushClientException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                System.out.println(String.format(
                        "requestId: %d, errorCode: %d, errorMsg: %s",
                        e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
    }
	
}
