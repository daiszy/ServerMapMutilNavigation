package Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBManage.DBManage;

public class GetUserInfoListService {

	public List<Map<String,Object>> getInfoList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select * from userinfo ORDER BY Status asc";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		try {
			//操作DB对象 
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);
			int count = 0;		
			while(resultSet.next()){
				count++;
				Map<String,Object> map = new HashMap<String, Object>();
				String telphone = resultSet.getString("Telphone");
				String name = resultSet.getString("Name");
				String ordersNum = resultSet.getString("OrdersNum");
				map.put("telphone", telphone);
				map.put("name", name);
				map.put("ordersNum", ordersNum);
				lists.add(map);	
			}
			/*Map<String,Object> map = new HashMap<String, Object>();
			map.put("count", count);
			lists.add(map);*/
			return lists;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lists;

	}
	
}
