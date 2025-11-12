import java.util.Scanner;
public class ParkingCharges{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double hour =0;
		
		while(true){
			System.out.print("Enter hours parked(or -1 to quit):");
            double hours = input.nextDouble();
			
			if (hours == -1){
				break;
			}
			double charge = calculateCharges(hours);
			hour += charge;
			
			System.out.printf("Charge for current customer: $%.2f%n",charge);
			System.out.printf("Checking total of yesterday's receipts: $%.2f%n%n",hour);
			
			
		}
		//Scanner.close();
		
	}
	public static double calculateCharges(double hours){
		double charge;
		
		if (hours<=3){
			charge = 2.00;
		} else {
			charge = 2.00+(Math.ceil(hours-3)* 0.50);
			charge = Math.min(charge,10.00);
		}
		return charge;
}
}