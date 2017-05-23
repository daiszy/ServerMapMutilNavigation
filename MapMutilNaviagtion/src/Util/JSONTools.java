package Util;

import net.sf.json.JSONObject;


/**JSON数据类型的转换类*/
public class JSONTools {

	public static String createJsonString(String key,Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}
