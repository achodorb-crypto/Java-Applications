public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        solveQueens(0);
        printBoard();
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        int i1 = row - 1;
        int j1 = col - 1;
        while (i1 >= 0 && j1 >= 0) {
            if (board[i1][j1] == 1) {
                return false;
            }
            i1--;
            j1--;
        }

        int i2 = row - 1;
        int j2 = col + 1;
        while (i2 >= 0 && j2 < BOARD_SIZE) {
            if (board[i2][j2] == 1) {
                return false;
            }
            i2--;
            j2++;
        }

        return true;
    }

    private static void solveQueens(int row) {
        if (row == BOARD_SIZE) {
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                solveQueens(row + 1);
                if (row == BOARD_SIZE - 1) {
                    return;
                }
                board[row][col] = 0;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}