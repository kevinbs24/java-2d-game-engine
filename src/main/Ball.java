package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Ball {
	public boolean gameOver = false;
	public int x, y;
	public int size = 12;
	public int speed = 5;
	public int dx = speed;
	public int dy = -speed;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void checkWallCollision() {
		if (x <= 0 || x + size >= 600)
			dx *= -1;
		if (y <= 0)
			dy *= -1;
		if (y >= 600)
			gameOver = true;
	}

	public void checkPaddleCollision(Paddle p) {
		if (y + size >= p.y && x + size >= p.x && x <= p.x + p.width) {
			dy *= -1;
			y = p.y - size;
		}
	}

	public void checkBrickCollisions(List<Brick> bricks) {
		for (Brick b : bricks) {
			if (b.destroyed)
				continue;

			if (x + size >= b.x && x <= b.x + b.width && y + size >= b.y && y <= b.y + b.height) {

				b.destroyed = true;
				dy *= -1;
				break;
			}
		}
	}

	public void draw(Graphics g2) {

		g2.setColor(Color.GREEN);
		g2.fillOval(x, y, size, size);
	}
}
