import processing.core.PApplet;
import java.util.Random;

public class Game15 extends PApplet {

    private int[][] gameField;
    private float x;
    private float y;
    private float extent;
    private final Random random = new Random();

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        gameField = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameField[i][j] = count++;
            }
        }
        shuffleGame();
        x = width / 3f;
        y = 200f;
        extent = (width / 3f) / 4;
    }

    @Override
    public void draw() {
        background(0);
        init();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameField[i][j] != 16) {
                    fill(255, 255, 0);
                    textSize(40);
                    textAlign(CENTER, CENTER);
                    text(gameField[i][j], x + extent * j + extent / 2f, y + i * extent + extent / 2f);
                }
            }
        }
    }

    public void init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                fill(100, 0, 255);
                square(x + extent * j, y + i * extent, extent);
            }
        }
    }

    @Override
    public void keyPressed() {
        switch (keyCode) {
            case UP:
                move(-1, 0);
                break;
            case DOWN:
                move(1, 0);
                break;
            case LEFT:
                move(0, -1);
                break;
            case RIGHT:
                move(0, 1);
                break;
        }
    }

    public void move(int rowOffset, int colOffset) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameField[i][j] == 16) {
                    int newRow = i + rowOffset;
                    int newCol = j + colOffset;
                    if (isValid(newRow, newCol)) {
                        gameField[i][j] = gameField[newRow][newCol];
                        gameField[newRow][newCol] = 16;
                    }
                    return;
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < 4 && col >= 0 && col < 4;
    }

    private void shuffleGame() {
        for (int i = 0; i < 1000; i++) {
            int direction = random.nextInt(4);
            switch (direction) {
                case 0 -> move(-1, 0);
                case 1 -> move(1, 0);
                case 2 -> move(0, -1);
                case 3 -> move(0, 1);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game15");
    }
}
