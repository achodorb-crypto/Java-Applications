public class UserClass{
	
	static int count = 0;
	
	UserClass(String na, int ag,int id){
		this.name = na;
		this.age = ag;
		this.idCard = id;
		count += 1;
	}
}