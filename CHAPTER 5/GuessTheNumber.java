import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;
        int tries = 0;

        do {
            System.out.print("Guess a number between 1 and 1000: ");
            guess = scanner.nextInt();
            tries++;

            if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + tries + " tries.");
            }
        } while (guess != number);
    }
}