public class SingleDimensionalArray{
	public static void main(String[] args){
		String[] names = {"Benita","Deborah","Cyracus","Darlington","Anita"};
		int[] ages = {17,48,54,23,20};
		
		for(int i = 0; i < 5; i++){
			System.out.printf("%s you are %d years old, you are getting old!!!! %n",names[i],ages[i]);
		}
	}
}