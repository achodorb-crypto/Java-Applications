public class SingleDimensionalArray1{
	public static void main(String[] args){
		String[] names = {"Benita","Deborah","Cyracus","Darlington","Anita","Jemma"};
		int[] ages = {17,48,54,23,20,155};
		
		for(int i = 0; i < 6; i++){
			System.out.printf("%s you are %d years old, you are getting old!!!! %n",names[i],ages[i]);
		}
	}
}