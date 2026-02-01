package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Ball {

    public int x, y;
    public final int size = 12;
    private final int speed = 5;
    private int dx = speed;
    private int dy = -speed;

    public boolean gameOver = false;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        dx = speed;
        dy = -speed;
        gameOver = false;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void checkWallCollision() {
        if (x <= 0 || x + size >= GameState.SCREEN_WIDTH)
            dx *= -1;

        if (y <= 0)
            dy *= -1;

        if (y >= GameState.SCREEN_HEIGHT)
            gameOver = true;
    }

    public void checkPaddleCollision(Paddle p) {
        if (y + size >= p.y &&
            x + size >= p.x &&
            x <= p.x + p.width &&
            dy > 0) {

            dy *= -1;
            y = p.y - size;
        }
    }

    public void checkBrickCollisions(List<Brick> bricks) {
        for (Brick b : bricks) {
            if (b.destroyed) continue;

            if (x + size >= b.x &&
                x <= b.x + b.width &&
                y + size >= b.y &&
                y <= b.y + b.height) {

                b.destroyed = true;
                dy *= -1;
                break;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, size, size);
    }
}
