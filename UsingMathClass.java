import java.util.Scanner;

public class UsingMathClass{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter any number of your choice: ");
		int num1 = input.nextInt();
		
		System.out.print("Enter any number of your choice: ");
		int num2 = input.nextInt();
		
		System.out.print("Enter any number to find the square root: ");
		int squareRootNum= input.nextInt();
		
		int castedSquareRootnum =(int) Math.sqrt(squareRootNum);
		//int castedpower = (int) Math.pow(num1,num2);
	
		//output
		System.out.printf("The absolute value of the number is  %d & %d%n",Math.abs(num1),Math.abs(num2));
		System.out.printf("The maximum value of the number is  %d%n",Math.max(num1,num2));
		System.out.printf("The minimum value of the number is  %d%n",Math.min(num1,num2));
		System.out.printf("The square root is  %d%n",castedSquareRootnum);
		System.out.printf("The power is  %f%n",Math.pow(num1,2)*Math.pow(num2,2));
		System.out.printf("The random number is  %f%n",Math.random());
		
		
	}
}