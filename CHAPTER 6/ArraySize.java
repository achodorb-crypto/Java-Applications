public class ArraySize {
    public static void main(String[] args) {
        int size = 10; // default size
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid command-line argument. Using default size.");
            }
        }

        int[] array = new int[size];
        
    }
}