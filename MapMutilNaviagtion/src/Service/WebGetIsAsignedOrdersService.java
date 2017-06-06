package Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBManage.DBManage;

/**获取已分配订单*/
public class WebGetIsAsignedOrdersService {

//	已分配订单
	public List<Map<String,Object>> getIsAsignedOrders() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select * from OrderInfo where Status = 1";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		try {
			//操作DB对象 
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);					
			while(resultSet.next()){
				Map<String,Object> map = new HashMap<String, Object>();
				String Longitude = resultSet.getString("Longitude");
				String Latitude = resultSet.getString("Latitude");
				String StartTime = resultSet.getString("StartTime");
				String OrderId = resultSet.getString("OrderInfoId");
				String Status = resultSet.getString("Status");
				String SendTime = resultSet.getString("SendTime");
				String ContactPhone = resultSet.getString("ContactPhone");
				String Money = resultSet.getString("Money");
				String Deatail = resultSet.getString("Deatail");
				map.put("Longitude", Longitude);
				map.put("Latitude", Latitude);
				map.put("StartTime", StartTime);
				map.put("OrderId", OrderId);
				map.put("Status", Status);
				map.put("SendTime", SendTime);
				map.put("ContactPhone", ContactPhone);
				map.put("Money", Money);
				map.put("Deatail", Deatail);
				lists.add(map);	
			}
			return lists;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lists;
		
	}
}
