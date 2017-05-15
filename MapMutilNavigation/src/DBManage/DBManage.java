package DBManage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement; 

//操作数据库
public class DBManage {

	//数据库连接常量
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "gaoxixi";
	public static final String URL = "jdbc:mysql://locahost:3306/mapmutilnavigation";
	
	//静态成员，支持单台模式
	private static DBManage per = null;
	private Connection connection = null;
	private Statement statement = null;
	
	private DBManage(){
		
	}
	public static DBManage creatInstance() {
		if(per == null)
		{
			per = new DBManage();
			per.initDB();
		}
		return per;
	}
	//加载驱动
	public void initDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//连接数据库，获取句柄+对象
	public void connectDB() {
		System.out.println("正在连接数据库...");
		try {
			connection = DriverManager.getConnection(URL,USER,PASS);
			statement = connection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("SqlManage:Connect to database successful.");
	}
	
	//关闭数据库，关闭对象，释放句柄
	public void closeDB() {
		System.out.println("Close connection to database...");
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Close database successful.");
	}
	
	//查询
	public ResultSet excuteQuery(String sql) {
		ResultSet rSet = null;
		try {
			rSet = statement.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rSet;
	}
	
	//增添，删除，修改
	public int executeUpdate(String sql) {
		int ret = 0;
		try {
			ret = statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret;
	}
}
