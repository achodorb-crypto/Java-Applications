import java.util.Random;

public class KnightsTour2 {
    // ...

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        Random random = new Random();
        int[] tourLengths = new int[BOARD_SIZE * BOARD_SIZE + 1];

        for (int i = 0; i < 1000; i++) {
            int row = 0;
            int col = 0;
            int moveCount = 1;

            // Reset the board
            for (int j = 0; j < BOARD_SIZE; j++) {
                for (int k = 0; k < BOARD_SIZE; k++) {
                    board[j][k] = 0;
                }
            }

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

            tourLengths[moveCount]++;
        }

        printTourLengths(tourLengths);
    }

    // ...

    private static void printTourLengths(int[] tourLengths) {
        System.out.println("Tour Lengths:");
        for (int i = 0; i < tourLengths.length; i++) {
            System.out.println(i + ": " + tourLengths[i]);
        }
    }
}