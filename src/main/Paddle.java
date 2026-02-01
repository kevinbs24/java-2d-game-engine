package main;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
    public int x, y;
    public int width = 80;
    public int length = 20;
    public int speed = 6;

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
    
    public void draw(Graphics g) {
    	
    	g.setColor(Color.BLUE);
		g.fillRect(x, y, width, length);
    }

    public void update() {}
}
