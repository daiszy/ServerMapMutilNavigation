package Info;


/**用户基本信息，包括昵称、姓名、性别、手机号、所在城市等*/
public class UserInfo {

	static String nickName;
	static String name;
	static String sex;
	static String telphone;
	static String ofCity;
	static String grade;
	static String ordersNum;
	static String status;
	
	public  UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String nickName,String name,String sex,String telphone,String ofCity,String grade,String ordersNum,String status){
		super();
		this.nickName = nickName;
		this.name = name;
		this.sex = sex;
		this.telphone = telphone;
		this.ofCity = ofCity;
		this.grade = grade;
		this.ordersNum = ordersNum;
		this.status = status;
	}
	
	public void setNickName() {
		this.nickName = nickName;
	}
	public void setName() {
		this.name = name;
	}
	public void setSex() {
		this.sex = sex;
	}
	public void setTelphone() {
		this.telphone = telphone;
	}
	public void setOfCity() {
		this.ofCity = ofCity;	
	}
	public void setGrade() {
		this.grade = grade;
	}
	public void setOrdersNum() {
		this.ordersNum = ordersNum;		
	}
	public void setStatus() {
		this.status = status;
	}
	
	public static String getNickName() {
		return nickName;
	}
	public static String getName() {
		return name;
	}
	public static String getSex() {
		return sex;
	}
	public static String getTelphone() {
		return telphone;
	}
	public static String getOfCity() {
		return ofCity;
	}
	public static String getGrade() {
		return grade;
	}
	public static String getOrdersNum() {
		return ordersNum;
	}
	public static String getStatus() {
		return status;
	}
	/*public String toString() {
		
	}*/
}
