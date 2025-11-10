import java.util.Scanner;

public class GasMileage{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int totalMiles = 0;
        int totalGallons = 0;
        int tripCount = 0;
        
        System.out.print("Enter miles driven for trip (or -1 to quit): ");
        int miles = input.nextInt();
        
        while (miles != -1){
            System.out.print("Enter gallons used for trip: ");
            int gallons = input.nextInt();
            
            double mpg = (double) miles / gallons;
            System.out.printf("MPG for this trip: %.2f%n", mpg);
            
            totalMiles += miles;
            totalGallons += gallons;
            tripCount++;
            
            if (tripCount > 0){
                double combinedMPG = (double) totalMiles / totalGallons;
                System.out.printf("Combined MPG for all trips: %.2f%n", combinedMPG);
            }
            
            System.out.print("Enter miles driven for next trip (or -1 to quit): ");
            miles = input.nextInt();
        }
    }
}