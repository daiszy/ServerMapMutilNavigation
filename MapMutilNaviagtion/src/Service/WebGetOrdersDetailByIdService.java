package Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import DBManage.DBManage;

//根据订单编号获取订单详细信息
public class WebGetOrdersDetailByIdService {

	public List<Map<String,Object>> getOrdersDetail(String orderId){
		
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		String sql = "select * from OrderInfo "
			     + "where OrderInfoId ='"+orderId+"'";
		
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
						
		//操作DB对象
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);
			if(resultSet.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				String OrderInfoId = resultSet.getString("OrderInfoId");
				String StartTime = resultSet.getString("StartTime");
				String Longitude = resultSet.getString("Longitude");
				String Latitude = resultSet.getString("Latitude");
				String Status = resultSet.getString("Status");
				String SendTime = resultSet.getString("SendTime");
				String UserTel = resultSet.getString("UserTel");
				String ContactPhone = resultSet.getString("ContactPhone");
				String EndTime = resultSet.getString("EndTime");
				String Money = resultSet.getString("Money");
				String Deatail = resultSet.getString("Deatail");
				map.put("OrderInfoId", OrderInfoId);		
				map.put("StartTime", StartTime);	
				map.put("Longitude", Longitude);	
				map.put("Latitude", Latitude);	
				map.put("Status", Status);
				map.put("SendTime", SendTime);
				map.put("UserTel", UserTel);
				map.put("ContactPhone", ContactPhone);
				map.put("EndTime", EndTime);
				map.put("Money", Money);
				map.put("Deatail", Deatail);
				lists.add(map);
				sqlDbManage.closeDB();	
				return lists;
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		sqlDbManage.closeDB();
		return lists;
	}
}
