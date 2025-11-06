public class UserVariable{
	public static void main(String[] args){
		
		UserClass thing1 = new UserClass("Jemimah", 14,1);
		UserClass thing2 = new UserClass("Theophilus",24,2);
		UserClass thing3 = new UserClass("Somina",17,3);
		
		
		System.out.println("................................................");
		System.out.printf("Thing1 name  :%s%nThing1 age:%d%nThing1 idcard:%d%n",thing1.name,thing1.age,thing1.idcard);
		System.out.println();
		System.out.println("...................................................");
		System.out.printf("Thing2 name:%s%nThing2 age:%d%nThing2 idcard:%d%n",thing2.name,thing2.age,thing2.idcard);
		System.out.println();
		System.out.println("...................................................");
		System.out.printf("Thing3 name:%s%nThing3 age:%d%nThing3 idcard:%d%n",thing3.name,thing3.age,thing3.idcard);
		
		
		System.out.printf("The total count is:%d",UserClass.count);
		
	}	
		
		
		
}