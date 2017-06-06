package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DBManage.DBManage;
import Util.JSONTools;

public class WebGetLocationService {

	public List<Map<String,Object>> getLocation() {
		
		//JSONTools jsonTools = new JSONTools();
		
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		//查询数据库中的记录
		String selectSql = "select * from location";
		
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		
		try {
			//操作DB对象
			ResultSet resultSet = sqlDbManage.excuteQuery(selectSql);
			while(resultSet.next()){
				Map<String,Object> map = new HashMap<String, Object>();
				String telphone = resultSet.getString("Telphone");
				String latitude = resultSet.getString("Latitude");
				String longitude = resultSet.getString("Longitude");
				String name = resultSet.getString("Name");
				map.put("telphone", telphone);
				map.put("latitude", latitude);
				map.put("longitude", longitude);
				map.put("name", name);
				lists.add(map);	
			}
			return lists;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lists;
	}

	
}
