import java.util.Scanner;

public class SalaryCalculator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        for (int i = 1; i <= 3; i++){
            System.out.printf("Enter hours worked for employee %d: ", i);
            double hours = input.nextDouble();
            
            System.out.printf("Enter hourly rate for employee %d: $", i);
            double rate = input.nextDouble();
            
            double grossPay;
            if (hours <= 40){
                grossPay = hours * rate;
            } else {
                grossPay = (40 * rate) + ((hours - 40) * rate * 1.5);
            }
            
            System.out.printf("Gross pay for employee %d: $%.2f%n%n", i, grossPay);
        }
    }
}