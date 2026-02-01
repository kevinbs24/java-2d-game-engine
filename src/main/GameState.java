package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {

	public static final int TILE_SIZE = 25;
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;

	public Paddle paddle;
	public Ball ball;

	public GameState() {
		paddle = new Paddle(300, 420);
		ball = new Ball(320, 300);
		
		initBricks();
	}
	
	public List<Brick> bricks = new ArrayList<>();
	
	private void initBricks() {
	    for (int i = 0; i < 10; i++) {
	        bricks.add(new Brick(60 + i * 52, 80));
	    }
	}

	public void reset() {
		ball.gameOver = false;
	}

	public void update() {
		if (ball.gameOver == true)
			return;

		paddle.update();
        ball.update();
        ball.checkPaddleCollision(paddle);
        ball.checkWallCollision();
        ball.checkBrickCollisions(bricks);
	}
}
