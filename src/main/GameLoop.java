package main;

public class GameLoop implements Runnable {

	private final GameState state;
	private final GamePanel panel;
	private Thread thread;

	public GameLoop(GameState state, GamePanel panel) {
		this.state = state;
		this.panel = panel;
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override

	public void run() {
		final double fps = 60.0;
		final double nsPerFrame = 1_000_000_000.0 / fps;
		long last = System.nanoTime();
		double acc = 0;

		while (thread != null) {
			long now = System.nanoTime();
			acc += (now - last) / nsPerFrame;
			last = now;

			while (acc >= 1.0) {
				state.update();
				panel.repaint();
				acc -= 1.0;
			}
			// simple sleep to reduce CPU
			try {
				Thread.sleep(1);
			} catch (InterruptedException ignored) {
			}
		}
	}
}
