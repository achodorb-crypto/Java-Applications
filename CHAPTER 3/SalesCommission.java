import java.util.Scanner;

public class SalesCommission{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double totalSales = 0;
        
        System.out.println("Enter the number of items sold for each category:");
        System.out.print("Cars ($2399.99): ");
        int cars = input.nextInt();
        totalSales += cars * 2399.99;
        
        System.out.print("Laptops ($1295.75): ");
        int laptops = input.nextInt();
        totalSales += laptops * 1295.75;
        
        System.out.print("Phones ($150.95): ");
        int phones = input.nextInt();
        totalSales += phones * 150.95;
        
        System.out.print("Earpods($35.89): ");
        int earPods = input.nextInt();
        totalSales += earPods * 35.89;
        
        double earnings = 200 + (0.09 * totalSales);
        System.out.printf("Total sales: $%.2f%n", totalSales);
        System.out.printf("Earnings: $%.2f%n", earnings);
    }
}