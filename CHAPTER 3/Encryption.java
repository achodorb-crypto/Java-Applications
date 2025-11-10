import java.util.Scanner;

public class Encryption{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a four-digit integer to encrypt: ");
        int number = input.nextInt();
        
        // Extract digits
        int digit1 = number / 1000;
        int digit2 = (number % 1000) / 100;
        int digit3 = (number % 100) / 10;
        int digit4 = number % 10;
        
        // Encrypt each digit
        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;
        
        // Swap digits
        int temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        
        // Form encrypted number
        int encryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
        
        System.out.printf("Encrypted number: %04d%n", encryptedNumber);
    }
}