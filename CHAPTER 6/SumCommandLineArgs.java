public class SumCommandLineArgs {
    public static void main(String[] args) {
        double sum = 0.0;
        for (String arg : args) {
            try {
                sum += Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                System.err.println("Invalid command-line argument: " + arg);
            }
        }
        System.out.println("Sum: " + sum);
    }
}
    