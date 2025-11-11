public class LocalVariableWithReturnType{
	
	public static void main(String[] args){
		int num = 16;
		
		int result = myPrintMethod();
		System.out.println("The value of num is"+num);
		System.out.printf("The result is %d%n",result);
		myMethod();
		
	}
	// local static variable
	public static void myMethod(){
		int x = 20;
		System.out.println(x);
	}
	
	public static int myPrintMethod(){
		int x = 50;
		return x;
	}
}