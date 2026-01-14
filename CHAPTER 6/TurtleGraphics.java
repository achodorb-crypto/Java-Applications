import java.util.Scanner;

public class TurtleGraphics {
    private static final int SIZE = 20;

    public static void main(String[] args) {
        int[][] floor = new int[SIZE][SIZE]; // 0 = blank, 1 = drawn
        int row = 0, col = 0;               // turtle starts at (0,0)
        int direction = 0;                   // 0=right,1=down,2=left,3=up
        boolean penDown = false;

        // Example turtle commands (from your problem)
        int[] commands = {
            2, 5,12, 3, 5,12, 3, 5,12, 3, 5,12, 1, 6, 9
        };

        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];

            switch (cmd) {
                case 1: // Pen up
                    penDown = false;
                    break;
                case 2: // Pen down
                    penDown = true;
                    break;
                case 3: // Turn right 90 degrees
                    direction = (direction + 1) % 4;
                    break;
                case 4: // Turn left 90 degrees
                    direction = (direction + 3) % 4;
                    break;
                case 5: // Move forward n spaces
                    int spaces = commands[++i]; // next value is number of spaces
                    for (int s = 0; s < spaces; s++) {
                        if (penDown) floor[row][col] = 1;

                        // Move turtle in current direction
                        switch (direction) {
                            case 0: if (col + 1 < SIZE) col++; break; // right
                            case 1: if (row + 1 < SIZE) row++; break; // down
                            case 2: if (col - 1 >= 0) col--; break;   // left
                            case 3: if (row - 1 >= 0) row--; break;   // up
                        }
                    }
                    if (penDown) floor[row][col] = 1; // mark final position
                    break;
                case 6: // Display floor
                    displayFloor(floor);
                    break;
                case 9: // End program
                    System.out.println("Program ended.");
                    return;
                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }
    }

    // Display the floor array
    private static void displayFloor(int[][] floor) {
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(floor[r][c] == 1 ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}