package Service;

import java.sql.ResultSet;

import DBManage.DBManage;

public class LoginService {

	public Boolean login(String username,String password) {
		//获取sql查询语句
		String logSql = "select * from login"
				+ " where UserTel ='"+username+"'"
			    + "and UserPassword = '"+password+"'";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB();
		
		//操作DB对象
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(logSql);
			if(resultSet.next())
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
	
	/*public Boolean register(String username,String password) {
		//获取sql查询语句
		String regSql = "insert into "
		return false;
	}*/
}
