package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    public int x, y;
    public int size = 12;
    public int dx = 3;
    public int dy = -3;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void checkWallCollision() {
        if (x <= 0 || x + size >= 640) dx *= -1;
        if (y <= 0) dy *= -1;
    }

    public void checkPaddleCollision(Paddle p) {
        if (y + size >= p.y &&
            x + size >= p.x &&
            x <= p.x + p.width) {
            dy *= -1;
            y = p.y - size;
        }
    }
    
public void draw(Graphics g) {
    	
    	g.setColor(Color.GREEN);
		g.fillOval(x, y, size, size);
    }
}
