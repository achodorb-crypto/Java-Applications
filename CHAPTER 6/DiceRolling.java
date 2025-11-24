import java.util.Random;
public class DiceRolling {
    public static void main(String[] args) {
        int[] frequencies = new int[11]; // 2-12
        Random random = new Random();
        for (int i = 0; i < 36_000_000; i++) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            frequencies[sum - 2]++;
        }
        System.out.println("Sum\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println((i + 2) + "\t" + frequencies[i]);
        }
    }
}