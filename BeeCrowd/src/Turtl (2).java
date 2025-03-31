import java.util.Scanner;

public class Trutl {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static int direction = 1;
    static boolean penDown = true;
    static int x = 0;
    static int y = 0;

    static final char[][] AREA_OF_TURTLE = new char[20][20];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < AREA_OF_TURTLE.length; i++) {
            for (int j = 0; j < AREA_OF_TURTLE.length; j++) {
                AREA_OF_TURTLE[i][j] = '.';
            }
        }

        while (true) {
            String command = in.next();

            switch (command) {
                case "Print":
                    printArea();
                    break;
                case "Move":
                    move(in);
                    break;
                case "TurnRight":
                    direction = (direction == LEFT) ? UP : direction + 1;
                    break;
                case "TurnLeft":
                    direction = (direction == UP) ? LEFT : direction - 1;
                    break;
                case "PenDown":
                    penDown = true;
                    break;
                case "PenUp":
                    penDown = false;
                    break;
                case "Exit":
                    return;
            }
        }
    }

    private static void move(Scanner in) {
        int steps = in.nextInt();

        for (int i = 0; i < steps; i++) {
            switch (direction) {
                case UP:
                    x = Math.max(0, x - 1);
                    break;
                case RIGHT:
                    y = Math.min(AREA_OF_TURTLE[0].length - 1, y + 1);
                    break;
                case DOWN:
                    x = Math.min(AREA_OF_TURTLE.length - 1, x + 1);
                    break;
                case LEFT:
                    y = Math.max(0, y - 1);
                    break;
            }
            if (penDown) {
                AREA_OF_TURTLE[x][y] = '*';
            }
        }
    }

    private static void printArea() {
        for (int i = 0; i < AREA_OF_TURTLE.length; i++) {
            for (int j = 0; j < AREA_OF_TURTLE[i].length; j++) {
                System.out.print(AREA_OF_TURTLE[i][j] + " ");
            }
            System.out.println();
        }
    }
}
