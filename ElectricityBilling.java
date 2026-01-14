import java.util.Scanner;

public class ElectricityBilling{
	public enum CustomerType{
		REGULAR,
		BUSINESS,
		VIP
	}
	public static void main(String[] args)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter units consumed: ");
        int units = scanner.nextInt();

        System.out.println("Select customer type:");
        System.out.println("1. REGULAR");
        System.out.println("2. BUSINESS");
        System.out.println("3. VIP");
        int typeChoice = scanner.nextInt();
	}
	public static void calculateBill(int units, CustomerType type){
		int bill =0;
		if(units <= 100) bill = units * 30;
		else if(units <= 300) bill = 100*30+ (units -100)*25;
		else bill = 100*30+200*25+(units - 300)*20;
		
		double discount = switch(type){
			case REGULAR -> 0;
			case BUSINESS -> 0.05;
			case VIP -> 0.10;
		};
		return bill * (1-discount);
		
	}
	
}
}