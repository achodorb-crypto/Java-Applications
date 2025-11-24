public class ModifiedApplication{
	public static double fibonacci(double n) {
    if (n == 0 || n == 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

public static void main(String[] args) {
    double n = 0;
    while (true) {
        try {
            double fib = fibonacci(n);
            System.out.println("Fibonacci(" + n + ") = " + fib);
            n++;
        } catch (ArithmeticException e) {
            System.out.println("Largest Fibonacci number: " + fibonacci(n - 1));
            break;
        }
    }
}
}
	