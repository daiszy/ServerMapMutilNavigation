package Service;

import java.sql.ResultSet;

import DBManage.DBManage;

public class WebEditOrdersService {

	public boolean editOrders(String orderId,String ContactPhone,String SendTime,String Detail) {
		String updateSql = "update OrderInfo set ContactPhone='"+ContactPhone+"',SendTime='"+SendTime+"',Deatail='"+Detail+"' where OrderInfoId='"+orderId+"'";
		
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
