public class CheckerboardPattern{
    public static void main(String[] args){
        int row = 1;
        
        while (row <= 8) {
            if (row % 2 == 0) {
                System.out.print(" ");
            }
            
            int column = 1;
            while (column <= 8) {
                System.out.print("* ");
                column++;
            }
            
            System.out.println();
            row++;
        }
    }
}