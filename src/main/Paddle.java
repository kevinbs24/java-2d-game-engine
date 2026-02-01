package main;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
    public int x, y;
    public int width = 80;
    public int length = 20;
    public int speed = 10;

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
    
    public void checkWallCollision() {
		if (x <= 0)
			x = 0;
		if (x + width >= 600)
			x = 600 - width;
	}
    
    public void draw(Graphics g2) {
    	
    	g2.setColor(Color.BLUE);
		g2.fillRect(x, y, width, length);
    }

    public void update() {
    	checkWallCollision();
    }
}
