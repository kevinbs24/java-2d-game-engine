package main;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    public int x, y;
    public final int width = 80;
    public final int height = 20;
    private final int speed = 12;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void update() {
        if (x < 0) x = 0;
        if (x + width > GameState.SCREEN_WIDTH)
            x = GameState.SCREEN_WIDTH - width;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
