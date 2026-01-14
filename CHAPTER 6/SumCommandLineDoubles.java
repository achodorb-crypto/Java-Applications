public class SumCommandLineDoubles {
    public static void main(String[] args) {

        double sum = 0.0;

        // Use enhanced for loop to process each argument
        for (String arg : args) {
            try {
                double value = Double.parseDouble(arg); // convert String to double
                sum += value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number ignored: " + arg);
            }
        }

        System.out.println("Sum of command-line doubles: " + sum);
    }
}