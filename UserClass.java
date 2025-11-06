public class UserClass{
	
	String name;
	int age;
	int idcard;
	
	static int count = 0;
	
	UserClass(String name, int age,int idcard){
		this.name = name;
		this.age = age;
		this.idcard = idcard;
		UserClass.count += 1;
	}
}