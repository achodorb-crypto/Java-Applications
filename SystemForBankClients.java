import java.util.Scanner;

public class SystemForBankClients{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num;
		int counter = 0;
		
		while (true){
			System.out.print("Enter a number:");
			num = input.nextInt();
			
			if(num == 0){
				break;
			}
			
			if(num ==1){
				System.out.printf("Language selection%n");
			}
			
			if(num == 2){
				System.out.printf("Customer support%n");
			}
			
			if(num == 3){
				System.out.printf("Check account balance%n");
			}
			
			
		    
			 
			
		}
		
	}
}