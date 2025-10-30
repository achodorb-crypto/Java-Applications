import java.util.Scanner;

public class IfElseIfStatement{
	public static void main(String[] args){
		
		// Scanner object has been created
		Scanner input = new Scanner(System.in);
		
		//variable declaration
		int mark;
		String fullName;
		
		//prompt user for input
		System.out.print("Enter your full name: ");
		fullName = input.nextLine();
		
		//prompt user to input mark
		System.out.print("Enter your mark: ");
		mark = input.nextInt();
		
		if(mark >= 80){
			System.out.printf("FullName: %s, Mark %d your grade is A%n",fullName,mark);
		}
		else if(mark >= 75){
			System.out.printf("FullName: %s, Mark %d your grade is B%n",fullName,mark);
		}
		else if (mark >= 65){
			System.out.printf("FullName: %s, Mark %d your grade is C%n",fullName,mark);
		}
		else if(mark >= 55 ){
			System.out.printf("FullName: %s, Mark %d your grade is D%n",fullName,mark);
		}
		else if(mark >= 45){
			System.out.printf("FullName: %s, Mark %d your grade is E%n",fullName,mark);
		}
		else{
			System.out.printf("FullName: %s, Mark %d your grade is F%n",fullName,mark);
		}
		
				
		
		
		
	}
}