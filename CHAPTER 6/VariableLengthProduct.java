public class VariableLengthProduct {

    // Method to calculate product using varargs
    public static int product(int... numbers) {
        int result = 1; // Start with 1 for multiplication

        for (int num : numbers) {
            result *= num;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test with different number of arguments
        System.out.println("Product of 2, 3, 4: " + product(2, 3, 4));
        System.out.println("Product of 5, 6: " + product(5, 6));
        System.out.println("Product of 7: " + product(7));
        System.out.println("Product of 1, 2, 3, 4, 5: " + product(1, 2, 3, 4, 5));
        System.out.println("Product of no numbers: " + product()); // returns 1
    }
}