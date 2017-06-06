package Service;

import DBManage.DBManage;

public class WebDeleteOrdersService {

	public boolean deleteOrders(String orderId) {
    String deleteSql = "DELETE from OrderInfo where OrderInfoId='"+orderId+"'";
		
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
