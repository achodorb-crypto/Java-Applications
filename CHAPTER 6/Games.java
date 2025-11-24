public class Games {
    public static void main(String[] args) {
        int[][] sales = new int[5][4]; // 5 products, 4 salespeople
        // read sales data
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                System.out.println("Product " + (i + 1) + ", Salesperson " + (j + 1) + ": " + sales[i][j]);
            }
        }
    }
}