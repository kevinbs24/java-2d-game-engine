package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GameState {

	private final int TILE_SIZE = 25;
	private final int SCREEN_WIDTH = 600;
	private final int SCREEN_HEIGHT = 600;

	private boolean gameOver = false;

	private char direction = 'R';

	private Point head, newHead, food;

	Random random = new Random();

	// Snake body = list of positions. Ordered list of Point objects, and each Point
	// represents a tile position
	ArrayList<Point> snake = new ArrayList<>();

	public GameState() {

		snake.add(new Point(5, 5)); // head

		spawnFood();
	}

	public void spawnFood() {

		final int maxX = SCREEN_WIDTH / TILE_SIZE;
		final int maxY = SCREEN_HEIGHT / TILE_SIZE;

		while (true) {

			Point p = (new Point(random.nextInt(maxX), random.nextInt(maxY)));

			if (!snake.contains(p)) {

				food = p;
				break;
			}
		}
	}

	void draw(Graphics g) {

		// food
		g.setColor(Color.RED);
		g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

		// snake
		g.setColor(Color.GREEN);
		for (Point p : snake) {
			g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		}

		if (gameOver) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", SCREEN_WIDTH / 2 - 40, SCREEN_HEIGHT / 2);
		}
	}

	// update modifies data
	void update() {

		if (gameOver)
			return;

		head = snake.get(0);
		newHead = new Point(head);

		switch (getDirection()) {
		case 'U':
			newHead.y--;
			break;
		case 'D':
			newHead.y++;
			break;
		case 'L':
			newHead.x--;
			break;
		case 'R':
			newHead.x++;
			break;
		}

		for (int i = 1; i < snake.size(); i++) {
			if (newHead.equals(snake.get(i))) {
				gameOver = true;
				return;
			}
		}

		if (newHead.x < 0 || newHead.y < 0 || newHead.x >= SCREEN_WIDTH / TILE_SIZE
				|| newHead.y >= SCREEN_HEIGHT / TILE_SIZE) {
			gameOver = true;
			return;
		}

		boolean ateFood = newHead.equals(food);

		snake.add(0, newHead);

		if (ateFood) {

			spawnFood();
		} else {
			snake.remove(snake.size() - 1);
		}
	}

	public int getScreenWidth() {
		return SCREEN_WIDTH;
	}

	public int getScreenHeight() {
		return SCREEN_HEIGHT;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
