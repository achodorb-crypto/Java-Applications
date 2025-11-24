public class LargestFibonacciNumber{
	public static void main(String[] args) {
    int n = 0;
    while (true) {
        try {
            int fib = fibonacci(n);
            System.out.println("Fibonacci(" + n + ") = " + fib);
            n++;
        } catch (ArithmeticException e) {
            System.out.println("Largest Fibonacci number: " + fibonacci(n - 1));
            break;
        }
    }
}
	
}
	
