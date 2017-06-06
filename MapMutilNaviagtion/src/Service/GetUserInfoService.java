package Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DBManage.DBManage;

import com.mysql.fabric.xmlrpc.base.Array;

//根据手机号获得用户信息
public class GetUserInfoService {

	public Map<String,Object> getUserInfo(String username) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		String sql = "select * from userinfo "
				     + "where Telphone ='"+username+"'";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
				
		//操作DB对象
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);
			if(resultSet.next()){
				//获取昵称
				String nickName = resultSet.getString("NickName");
				String name = resultSet.getString("Name");
				String sex = resultSet.getString("Sex");
				String telphone = resultSet.getString("Telphone");
				String ofCity = resultSet.getString("OfCity");
				String grade = resultSet.getString("Grade");
				String ordersNum = resultSet.getString("OrdersNum");
				String status = resultSet.getString("Status");
				map.put("nickName", nickName);		
				map.put("name", name);	
				map.put("sex", sex);	
				map.put("telphone", telphone);	
				map.put("ofCity", ofCity);
				map.put("grade", grade);
				map.put("ordersNum", ordersNum);
				map.put("status", status);
				sqlDbManage.closeDB();	
				return map;
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		sqlDbManage.closeDB();
		
		return map;
	}
}