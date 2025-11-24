
public class EightQueens2{
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        solveQueens(0);
        printBoard();
    }

    private static void solveQueens(int row) {
        if (row == BOARD_SIZE) {
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            board[row][col] = 1;
            if (isSafe(row, col)) {
                solveQueens(row + 1);
                if (row == BOARD_SIZE - 1) {
                    return;
                }
            }
            board[row][col] = 0;
        }
    }

    private static boolean isSafe(int row, int col) {
        // ...
    }

    private static void printBoard() {
        // ...
    }
}