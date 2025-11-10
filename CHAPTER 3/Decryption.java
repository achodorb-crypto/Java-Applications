import java.util.Scanner;

public class Decryption{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a four-digit integer to decrypt: ");
        int number = input.nextInt();
        
        // Extract digits
        int digit1 = number / 1000;
        int digit2 = (number % 1000) / 100;
        int digit3 = (number % 100) / 10;
        int digit4 = number % 10;
        
        // Swap digits back
        int temp = digit1;
        digit1 = digit3;
        digit3 = temp;
        
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;
        
        // Decrypt each digit
        digit1 = (digit1 + 3) % 10;  // Adding 3 is equivalent to subtracting 7 mod 10
        digit2 = (digit2 + 3) % 10;
        digit3 = (digit3 + 3) % 10;
        digit4 = (digit4 + 3) % 10;
        
        // Form decrypted number
        int decryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
        
        System.out.printf("Decrypted number: %04d%n", decryptedNumber);
    }
}