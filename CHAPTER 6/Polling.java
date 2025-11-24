import java.util.Scanner;

public class Polling {
    private static final int NUM_TOPICS = 5;
    private static final int NUM_RATINGS = 10;
    private static String[] topics = {"Topic 1", "Topic 2", "Topic 3", "Topic 4", "Topic 5"};
    private static int[][] responses = new int[NUM_TOPICS][NUM_RATINGS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            System.out.println("Rate the following topics from 1 to 10:");
            for (int j = 0; j < NUM_TOPICS; j++) {
                System.out.print(topics[j] + ": ");
                int rating = scanner.nextInt();
                responses[j][rating - 1]++;
            }
        }

        printResults();
    }

    private static void printResults() {
        System.out.println("Results:");
        for (int i = 0; i < NUM_TOPICS; i++) {
            System.out.print(topics[i] + ": ");
            for (int j = 0; j < NUM_RATINGS; j++) {
                System.out.print(responses[i][j] + " ");
            }
            System.out.println();
        }

        int maxTopic = 0;
        int maxRating = 0;
        int minTopic = 0;
        int minRating = Integer.MAX_VALUE;

        for (int i = 0; i < NUM_TOPICS; i++) {
            int sum = 0;
            for (int j = 0; j < NUM_RATINGS; j++) {
                sum += responses[i][j] * (j + 1);
            }
            if (sum > maxRating) {
                maxTopic = i;
                maxRating = sum;
            }
            if (sum < minRating) {
                minTopic = i;
                minRating = sum;
            }
        }

        System.out.println("Topic with highest rating: " + topics[maxTopic] + " with rating " + maxRating);
        System.out.println("Topic with lowest rating: " + topics[minTopic] + " with rating " + minRating);
    }
}