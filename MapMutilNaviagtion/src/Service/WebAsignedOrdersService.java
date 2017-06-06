package Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import push.PushMsgToAll;
import DBManage.DBManage;

public class WebAsignedOrdersService {

	public boolean isAsigned(String telphone){
		String sqlUpdateUserInfo = "update userinfo set Status = 1,OrdersNum = OrdersNum+1 where Telphone = "+telphone;
		//String sqlSelect = "select * from OrderInfo where Status = 0 limit 5";
		String sqlSelectUpdate = "update OrderInfo SET UserTel="+telphone+",Status = 1 WHERE Status=0 LIMIT 5";
		
		//获取订单记录
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB();
		try {
			//操作DB对象 
			int n1 = sqlDbManage.executeUpdate(sqlSelectUpdate);	
			int n2 = sqlDbManage.executeUpdate(sqlUpdateUserInfo);	
			if(n1 != 0 && n2 != 0)
			{
//				PushMsgToAll pushMsgToAll = new PushMsgToAll();
//				pushMsgToAll.pushMsgToAll(null);
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return false;
	}
	
}
