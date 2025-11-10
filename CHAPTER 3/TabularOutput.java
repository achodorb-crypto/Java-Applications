public class TabularOutput{
    public static void main(String[] args){
        System.out.println("N\t10*N\t100*N\t1000*N");
        
        int n = 1;
        while (n <= 5) {
            System.out.printf("%d\t%d\t%d\t%d%n", n, 10*n, 100*n, 1000*n);
            n++;
        }
    }
}