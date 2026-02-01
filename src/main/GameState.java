package main;

import java.util.ArrayList;
import java.util.List;

public class GameState {

	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;

	public Paddle paddle;
	public Ball ball;
	public List<Brick> bricks = new ArrayList<>();

	private int currentLevelIndex = 0;
	private Level currentLevel;

	public GameState() {
		
		loadLevel(0);
	}

	private void loadLevel(int index) {
		currentLevelIndex = index;
		currentLevel = LevelLibrary.LEVELS.get(index);

		paddle = new Paddle(260, 520);
		ball = new Ball(320, 300);

		bricks.clear();
		buildBricksFromLevel(currentLevel);
	}

	private void buildBricksFromLevel(Level level) {
		for (int row = 0; row < level.rows; row++) {
			for (int col = 0; col < level.cols; col++) {

				int x = level.startX + col * (level.brickWidth + level.spacing);
				int y = level.startY + row * (level.brickHeight + level.spacing);

				bricks.add(new Brick(x, y));
			}
		}
	}
	
	private boolean isLevelComplete() {
	    for (Brick b : bricks) {
	        if (!b.destroyed) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private void advanceLevel() {
	    if (currentLevelIndex + 1 >= LevelLibrary.LEVELS.size()) {
	        // No more levels — game complete (for now)
	        ball.gameOver = true;
	        return;
	    }

	    loadLevel(currentLevelIndex + 1);
	}

	 public void reset() { paddle = new Paddle(260, 520); ball = new Ball(294,
			 300); bricks = new ArrayList<>(); 
			 loadLevel(0);
			 }

	public void update() {
		if (ball.gameOver)
			return;

		paddle.update();
		ball.update();
		ball.checkWallCollision();
		ball.checkPaddleCollision(paddle);
		ball.checkBrickCollisions(bricks);
		
		if (isLevelComplete()) {
		    advanceLevel();
		}
	}
}
