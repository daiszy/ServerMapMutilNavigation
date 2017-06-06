package Service;

import DBManage.DBManage;

public class WebEditUserService {

	public boolean editOrders(String name,String sex,String telphone,String grade,String ofCity) {
		String updateSql = "update userinfo set Name='"+name+"',Sex='"+sex+"',Grade='"+grade+"',OfCity='"+ofCity+"' where Telphone='"+telphone+"'";
		
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		//操作DB对象
		try {
			int ret = sqlDbManage.executeUpdate(updateSql);
			if(ret != 0)
			{
				sqlDbManage.closeDB();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlDbManage.closeDB();
		return false;
	}
}
