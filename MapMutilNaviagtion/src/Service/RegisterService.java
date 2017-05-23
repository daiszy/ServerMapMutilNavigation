package Service;

import DBManage.DBManage;

//用户注册
public class RegisterService {

	public boolean register(String nickName,String name,String sex,String telphone,String ofCity,String password) {
		String insertSqlInfo = "insert into userinfo (NickName,Name,Sex,Telphone,OfCity) VALUES ('"+nickName+"','"+name+"','"+sex+"','"+telphone+"','"+ofCity+"')";
		String insertSqlLogin = "insert into login (UserTel,UserPassword) VALUES ('"+telphone+"','"+password+"')";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		int retInfo = sqlDbManage.executeUpdate(insertSqlInfo);
		int retLogin = sqlDbManage.executeUpdate(insertSqlLogin);
		if(retInfo != 0 && retLogin != 0){
			sqlDbManage.closeDB();
			return true;
		}
		sqlDbManage.closeDB();
		return false;
	}
}
