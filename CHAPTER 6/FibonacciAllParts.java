import java.util.Scanner;

public class FibonacciAllParts {

    // Method to calculate nth Fibonacci using int
    public static int fibonacciInt(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // Method to calculate nth Fibonacci using double
    public static double fibonacciDouble(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        double a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // Find largest Fibonacci that fits in int
    public static int largestIntFibonacci() {
        int a = 0, b = 1, fib = 0, n = 1;
        while (true) {
            fib = a + b;
            if (fib < 0) break; // overflow detected
            a = b;
            b = fib;
            n++;
        }
        System.out.println("Largest Fibonacci number in int: F(" + n + ") = " + b);
        return n;
    }

    // Find largest Fibonacci that fits precisely in double
    public static int largestDoubleFibonacci() {
        double a = 0, b = 1, fib = 0;
        int n = 1;
        while (true) {
            fib = a + b;
            if (Double.isInfinite(fib)) break; // exceeds double max
            a = b;
            b = fib;
            n++;
        }
        System.out.println("Largest Fibonacci number in double (approx integer precision): F(" + n + ") = " + b);
        return n;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Fibonacci Calculator");
        System.out.println("1. Calculate using int");
        System.out.println("2. Calculate using double");
        System.out.println("3. Find largest Fibonacci in int");
        System.out.println("4. Find largest Fibonacci in double");
        System.out.print("Choose option (1-4): ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter n: ");
                int n1 = input.nextInt();
                System.out.println("Fibonacci number F(" + n1 + ") = " + fibonacciInt(n1));
                break;
            case 2:
                System.out.print("Enter n: ");
                int n2 = input.nextInt();
                System.out.println("Fibonacci number F(" + n2 + ") = " + fibonacciDouble(n2));
                break;
            case 3:
                largestIntFibonacci();
                break;
            case 4:
                largestDoubleFibonacci();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}