package Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import push.PushMsgToAll;
import DBManage.DBManage;

public class WebAsignedOrdersService {

	public List<Map<String,Object>> isAsigned(String telphone){
		String sqlUpdateUserInfo = "update userinfo set Status = 1,OrdersNum = OrdersNum+1 where Telphone = "+telphone;
		//String sqlSelect = "select * from OrderInfo where Status = 0 limit 5";
		String sqlSelectUpdate = "update OrderInfo SET UserTel="+telphone+",Status = 1 WHERE Status=0 LIMIT 5";
		String sqlQuery = "select * from OrderInfo where status = 1 AND UserTel = "+telphone;
		
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		//获取订单记录
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB();
		ResultSet rt;
		try {
			//操作DB对象 
			int n1 = sqlDbManage.executeUpdate(sqlSelectUpdate);	
			int n2 = sqlDbManage.executeUpdate(sqlUpdateUserInfo);	
			rt = sqlDbManage.excuteQuery(sqlQuery);
			if(n1 != 0 && n2 != 0)
			{
//				PushMsgToAll pushMsgToAll = new PushMsgToAll();
//				pushMsgToAll.pushMsgToAll(null);
				while(rt.next()){
					Map<String,Object> map = new HashMap<String, Object>();
					String Longitude = rt.getString("Longitude");
					String Latitude = rt.getString("Latitude");
					String Deatail = rt.getString("Deatail");
					map.put("Longitude", Longitude);
					map.put("Latitude", Latitude);
					map.put("Deatail", Deatail);
					lists.add(map);	
				}
				return lists;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return lists;
	}
	
}
