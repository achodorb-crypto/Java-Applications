import java.util.Scanner;

public class EnhancedForLoop{
	public static void main(String[] args){
		//create a single dimensional array of size 10(String)
		String[] names = new String[10];
		
		//create a single dimensional array of size 10(integer)
		int[] marks = new int[10];
		
		//create the object of the scanner class
		Scanner scan = new Scanner(System.in);
		
		//get input from users
		for(int i = 0; i<10; i++){
		    System.out.print("Enter Student name:");
		    names[i] = scan.nextLine();
		
			System.out.print("Enter Student mark:");
			marks[i] = scan.nextInt();
			scan.nextLine();
		
		
		System.out.println("===================================");
		}
		
		//Transverse through the arrays to display the elements of the arrays
		
		System.out.println("Elements of the Names array are:");
		for(String name : names){
			System.out.printf("%s%n",name);
		}
		
		
		System.out.println("");
		System.out.println("Elements of the Marks array are:");
		for(int mark : marks){
			System.out.printf("%d%n",mark);
		}
	}
}