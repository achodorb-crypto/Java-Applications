public class RoundingNumbersToFactors{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a double value: ");
        double x = scanner.nextDouble();
        System.out.println("Original number: " + x);
        System.out.println("Rounded to integer: " + roundToInteger(x));
        System.out.println("Rounded to tenths: " + roundToTenths(x));
        System.out.println("Rounded to hundredths: " + roundToHundredths(x));
        System.out.println("Rounded to thousandths: " + roundToThousandths(x));
    }

    public static double roundToInteger(double number) {
        return Math.floor(number + 0.5);
    }

    public static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }

    public static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }

    public static double roundToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }
}