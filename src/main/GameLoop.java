package main;

import java.awt.Point;

public class GameLoop implements Runnable {
	
	GamePanel gp;
	
	public GameLoop(GamePanel gp) {
		
		this.gp = gp;
	}

	Thread gameThread;

	// Swing does not give you a game loop, you must create one
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		// This is the formula for the game loop
		final double fps = 10;
		double drawInterval = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if (delta >= 1) {

				gp.update();
				gp.repaint();
				delta--;
			}
		}
	}
}
