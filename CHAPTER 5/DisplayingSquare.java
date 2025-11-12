public class DisplayingSquare{
	public static void main(String[] args){
	}
	public static void squareOfAsterisks(int side, char fillCharacter) {
    for (int i = 0; i < side; i++) {
        for (int j = 0; j < side; j++) {
            System.out.print(fillCharacter + " ");
        }
        System.out.println();
    }
}
}