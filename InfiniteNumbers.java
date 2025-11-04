import java.util.Scanner;

public class InfiniteNumbers{
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    int num;
		int counter = 0;
		
		while(true){
			
			System.out.println("Enter number: ");
			num = input.nextInt();
			
			if(num == -1){
				break;
			}
			
			if(num > 0)
				System.out.printf("This is a positive number%n");
			
			if(num < 1)
				System.out.printf("This is a negative number%n");
			
			if(num == 0)
				System.out.printf("This is a zero number%n");
			
		}
		
	}
}




                     