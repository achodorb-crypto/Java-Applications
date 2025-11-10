import java.util.Scanner;

public class TwoLargestNumbers{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        System.out.println("Enter 10 integers:");
        
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Enter number %d: ", i);
            int number = input.nextInt();
            
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
        }
        
        System.out.printf("The largest number is: %d%n", largest);
        System.out.printf("The second largest number is: %d%n", secondLargest);
    }
}