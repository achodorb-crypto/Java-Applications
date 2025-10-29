public class OperatorsPart2{
	public static void main(String[] args){
		int num1 = 30;
		int num2= 25;
		int num3 = 17;
		
		// AND LOGICAL OPERATOR(&&)
		boolean result = (num1 > num2) && (num1 > num3);
		System.out.printf("The result is %b%n",result);
		
		// OR LOGICAL OPERATOR(||)
		boolean result2 = (num1 > num2) || (num1 > num3);
		System.out.printf("The result is %b%n",result2);
		
		// NOT LOGICAL OPERATOR(!)
		boolean result3 = !((num1 > num2) && (num1 > num3));
		System.out.printf("The result is %b%n",result3);
		
		// PRE-INCREMENT UNARY OPERATOR
		System.out.println();
		int num4 = 10;
	    ++num4;
		System.out.println("Pre-increment operator ");
		System.out.printf(" Before: The result is %d%n",num4);
		System.out.printf(" after: The result is %d%n",++num4);
		
		// POST-INCREMENT UNARY OPERATOR
		System.out.println();
		System.out.println("Post-increment");
		int num5 = 10;
		num5++;
		System.out.printf("before: %d%n",num5);
		System.out.printf("after: %d%n",num5++);
		
		// Pre-decrement UNARY OPERATOR
		System.out.println();
		System.out.println("Pre-decrement operator ");
		System.out.printf(" Before: The result is %d%n",num4);
		System.out.printf(" after: The result is %d%n",--num4);
		
		// post-decrement unary operator
		System.out.println();
		System.out.println("Post-decrement operator ");
		System.out.printf(" Before: The result is %d%n",num5);
		System.out.printf(" after: The result is %d%n",num5--);
		
	}
}