package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Ball {

    public boolean gameOver = false;

    public int x, y;
    public int size = 12;

    public int dx = 4;
    public int dy = -4;

    private static final int MAX_BOUNCE_X = 6;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void checkWallCollision() {
        if (x <= 0 || x + size >= GameState.SCREEN_WIDTH) {
            dx *= -1;
        }

        if (y <= 0) {
            dy *= -1;
        }

        if (y >= GameState.SCREEN_HEIGHT) {
            gameOver = true;
        }
    }

    public void checkPaddleCollision(Paddle p) {
        Rectangle ballRect = new Rectangle(x, y, size, size);
        Rectangle paddleRect = new Rectangle(p.x, p.y, p.width, p.height);

        if (!ballRect.intersects(paddleRect)) return;

        int ballCenter = x + size / 2;
        int paddleCenter = p.x + p.width / 2;

        double hitPercent =
                (double)(ballCenter - paddleCenter) / (p.width / 2);

        dx = (int)(hitPercent * MAX_BOUNCE_X);
        dy = -Math.abs(dy);

        y = p.y - size; // prevent sticking
    }

    public void checkBrickCollisions(List<Brick> bricks) {
        Rectangle ballRect = new Rectangle(x, y, size, size);

        for (Brick b : bricks) {
            if (b.destroyed) continue;

            Rectangle brickRect =
                new Rectangle(b.x, b.y, b.width, b.height);

            if (!ballRect.intersects(brickRect)) continue;

            b.destroyed = true;

            resolveBrickBounce(ballRect, brickRect);
            break;
        }
    }

    private void resolveBrickBounce(Rectangle ball, Rectangle brick) {

        int overlapLeft   = ball.x + ball.width - brick.x;
        int overlapRight  = brick.x + brick.width - ball.x;
        int overlapTop    = ball.y + ball.height - brick.y;
        int overlapBottom = brick.y + brick.height - ball.y;

        int minX = Math.min(overlapLeft, overlapRight);
        int minY = Math.min(overlapTop, overlapBottom);

        if (minX < minY) {
            dx *= -1;
        } else {
            dy *= -1;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, size, size);
    }
}
