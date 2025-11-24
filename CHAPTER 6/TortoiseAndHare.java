import java.util.Random;

public class TortoiseAndHare {
    private static final int COURSE_LENGTH = 70;
    private static final int Tortoise = 1;
    private static final int Hare = 2;

    public static void main(String[] args) {
        int tortoisePosition = 1;
        int harePosition = 1;
        Random random = new Random();

        System.out.println("BANG !!!!! AND THEY'RE OFF !!!!!");

        while (tortoisePosition < COURSE_LENGTH && harePosition < COURSE_LENGTH) {
            int tortoiseMove = getTortoiseMove(random);
            tortoisePosition += tortoiseMove;
            if (tortoisePosition < 1) {
                tortoisePosition = 1;
            }

            int hareMove = getHareMove(random);
            harePosition += hareMove;
            if (harePosition < 1) {
                harePosition = 1;
            }

            printCourse(tortoisePosition, harePosition);

            if (tortoisePosition >= COURSE_LENGTH && harePosition >= COURSE_LENGTH) {
                System.out.println("It's a tie.");
                break;
            } else if (tortoisePosition >= COURSE_LENGTH) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                break;
            } else if (harePosition >= COURSE_LENGTH) {
                System.out.println("Hare wins. Yuch.");
                break;
            }
        }
    }

    private static int getTortoiseMove(Random random) {
        int move = random.nextInt(10) + 1;
        if (move <= 5) {
            return 3;
        } else if (move <= 7) {
            return -6;
        } else {
            return 1;
        }
    }

    private static int getHareMove(Random random) {
        int move = random.nextInt(10) + 1;
        if (move <= 2) {
            return 0;
        } else if (move <= 4) {
            return 9;
        } else if (move <= 5) {
            return -12;
        } else if (move <= 8) {
            return 1;
        } else {
            return -2;
        }
    }

    private static void printCourse(int tortoisePosition, int harePosition) {
        for (int i = 1; i <= COURSE_LENGTH; i++) {
            if (i == tortoisePosition && i == harePosition) {
                System.out.print("OUCH!!!");
            } else if (i == tortoisePosition) {
                System.out.print("T");
            } else if (i == harePosition) {
                System.out.print("H");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}