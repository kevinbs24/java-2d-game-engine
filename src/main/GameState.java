package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GameState {

	public static final int TILE_SIZE = 25;
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;

	private boolean gameOver = false;
	public Paddle paddle;
	public Ball ball;

	public GameState() {
		paddle = new Paddle(300, 420);
		ball = new Ball(320, 300);
	}

	public void reset() {
		gameOver = false;
	}

	public void update() {
		if (gameOver)
			return;

		paddle.update();
        ball.update();
        ball.checkPaddleCollision(paddle);
        ball.checkWallCollision();
	}

	// ===== Getters / setters =====

	public boolean isGameOver() {
		return gameOver;
	}
}
