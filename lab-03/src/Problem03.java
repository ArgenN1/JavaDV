import processing.core.PApplet;

public class Problem03 extends PApplet {
    private float x;
    private float y;
    private float speedX;
    private float speedY;
    private int rad;
    private int currentColor;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        x = width / 2f;
        y = height / 2f;

        speedX = 3f;
        speedY = 3f;

        rad = 100;

        currentColor = color(255, 0, 0);
    }

    @Override
    public void draw() {
        background(0, 0, 0);
        fill(currentColor);
        circle(x, y, rad);

        x += speedX;
        y += speedY;

        if (x >= width - rad / 2f || x <= rad / 2f) {
            speedX *= -1;
            changeColor();
        }

        if (y >= height - rad / 2f || y <= rad / 2f) {
            speedY *= -1;
            changeColor();
        }
    }

    private void changeColor() {
        if (currentColor == color(255, 0, 0)) {
            currentColor = color(0, 0, 255);
        } else if (currentColor == color(0, 0, 255)) {
            currentColor = color(0, 255, 0);
        } else if (currentColor == color(0, 255, 0)) {
            currentColor = color(255, 0, 0);
        }
    }

    public static void main(String[] args) {
        PApplet.main("Problem03");
    }
}