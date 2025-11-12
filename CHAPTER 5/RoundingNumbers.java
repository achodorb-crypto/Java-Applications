import java.util.Scanner;

public  class RoundingNumbers{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter any double value:");
		double x = input.nextDouble();
		int castrounded = (int) Math.floor(x+0.5);
		System.out.println("This is the original number"+ x);
		System.out.println("This is the rounded number"+ castrounded);
	}
}