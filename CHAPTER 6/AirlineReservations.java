import java.util.Scanner;

public class AirlineReservations {
    public static void main(String[] args) {
        boolean[] seats = new boolean[10];
        Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your number:");
		int choice = scanner.nextInt();
        while (true) {
            if (choice == 1) {
                System.out.println("This is the first class, Jesus is here");
				break;
            } else if (choice == 2) {
                System.out.println("This is the economy class,Jesus is here");
				break;
            } else {
                System.out.println("Invalid choice But Jesus lovesss you");
				break;
            }
        }
    }
}