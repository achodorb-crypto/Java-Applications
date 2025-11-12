 public class CoinToss {
    public static void main(String[] args) {
        Random random = new Random();
        int heads = 0;
        int tails = 0;

        for (int i = 0; i < 100; i++) {
            int toss = random.nextInt(2);
            if (toss == 0) {
                System.out.println("Heads");
                heads++;
            } else {
                System.out.println("Tails");
                tails++;
            }
        }

        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);
    }
} 