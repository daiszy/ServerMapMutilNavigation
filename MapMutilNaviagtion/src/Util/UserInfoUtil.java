package Util;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Info.UserInfo;

/**对用户基本信息进行封装，生成Map类型的数据*/
public class UserInfoUtil {

	public static List<Map<String,Object>> getMaps() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nickName",UserInfo.getNickName());
		map.put("name",UserInfo.getName());
		map.put("sex",UserInfo.getSex());
		map.put("telphone",UserInfo.getTelphone());
		map.put("ofCity",UserInfo.getOfCity());
		map.put("grade",UserInfo.getGrade());
		map.put("ordersNum",UserInfo.getOrdersNum());
		map.put("status",UserInfo.getStatus());
		list.add(map);
		return list;
	}
}
