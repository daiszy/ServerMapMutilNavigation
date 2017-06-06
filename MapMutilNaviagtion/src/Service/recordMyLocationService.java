package Service;

import java.sql.ResultSet;

import DBManage.DBManage;

//上传位置
public class recordMyLocationService {

	public boolean recordLocation(String telphone,String latitude,String longitude) {
		String selectSqlLocation = "select * from location"
				+ " where Telphone ='"+telphone+"'";
		String insertSqlLocation = "insert into location (Telphone,Latitude,Longitude) VALUES ('"+telphone+"','"+latitude+"','"+longitude+"')";
		String updateSqlLocation = "update location set Latitude = '"+latitude+"',Longitude = '"+longitude+"'where Telphone = '"+telphone+"'";
		
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		
		//操作DB对象查询
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(selectSqlLocation);
			if(resultSet.next())
			{
				//若存在这条记录则更新
				int retUpdate = sqlDbManage.executeUpdate(updateSqlLocation);
				if(retUpdate != 0){
				    sqlDbManage.closeDB();
					return true;
				}
			}else {
				//若不存在则插入一条记录
				int ret = sqlDbManage.executeUpdate(insertSqlLocation);
				if(ret != 0){
				    sqlDbManage.closeDB();
					return true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlDbManage.closeDB();
		return false;	
	}
}
