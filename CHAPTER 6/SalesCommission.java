import java.util.Scanner;

public class SalesCommission {
    public static void main(String[] args) {
        int[] counters = new int[9];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter sales amount (-1 to stop): ");
            double sales = scanner.nextDouble();

            if (sales == -1) {
                break;
            }

            double salary = 200 + (sales * 0.09);
            int range = (int) salary / 100;

            if (range < 2) {
                counters[0]++;
            } else if (range < 10) {
                counters[range - 2]++;
            } else {
                counters[8]++;
            }
        }

        System.out.println("Salary Range\tNumber of Salespeople");
        System.out.println("$200-299\t" + counters[0]);
        System.out.println("$300-399\t" + counters[1]);
        System.out.println("$400-499\t" + counters[2]);
        System.out.println("$500-599\t" + counters[3]);
        System.out.println("$600-699\t" + counters[4]);
        System.out.println("$700-799\t" + counters[5]);
        System.out.println("$800-899\t" + counters[6]);
        System.out.println("$900-999\t" + counters[7]);
        System.out.println("$1000 and over\t" + counters[8]);
    }
} 
    