import java.util.Random;

public class KnightsTour1 {
    private static final int BOARD_SIZE = 8;
    private static final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        Random random = new Random();
        int row = 0;
        int col = 0;
        int moveCount = 1;

        board[row][col] = moveCount;

        while (moveCount < BOARD_SIZE * BOARD_SIZE) {
            int[] move = getRandomMove(random);
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (isValidMove(board, newRow, newCol)) {
                row = newRow;
                col = newCol;
                moveCount++;
                board[row][col] = moveCount;
            }
        }

        printBoard(board);
    }

    private static int[] getRandomMove(Random random) {
        int index = random.nextInt(MOVES.length);
        return MOVES[index];
    }

    private static boolean isValidMove(int[][] board, int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}