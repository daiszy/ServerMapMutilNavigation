package Service;

import DBManage.DBManage;

public class WebDeleteUserService {

	public boolean deleteOrders(String telphone) {
	    String deleteSql = "DELETE from userinfo where Telphone='"+telphone+"'";
			
			//获取DB对象
			DBManage sqlDbManage = DBManage.creatInstance();
			sqlDbManage.connectDB(); 
			//操作DB对象
			try {
				int ret = sqlDbManage.executeUpdate(deleteSql);
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
