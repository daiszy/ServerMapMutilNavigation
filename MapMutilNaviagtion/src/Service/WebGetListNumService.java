package Service;

import java.sql.ResultSet;

import javassist.bytecode.stackmap.BasicBlock.Catch;
import DBManage.DBManage;

public class WebGetListNumService {

	public int getCount() {
		
		int count = 0;
		
		//查询数据库中的记录
		String selectSql = "select * from userinfo";
		
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
				
		try {
			  //操作DB对象
				ResultSet resultSet = sqlDbManage.excuteQuery(selectSql);
				
				while(resultSet.next()){
					count++;
					}
				return count;
			}catch (Exception e) {
				// TODO: handle exception
			}
		return count;
	}     
}
