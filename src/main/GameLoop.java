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
        final double fps = 10;
        final double interval = 1_000_000_000 / fps;
        double delta = 0;

        long last = System.nanoTime();

        while (thread != null) {
            long now = System.nanoTime();
            delta += (now - last) / interval;
            last = now;

            if (delta >= 1) {
                state.update();
                panel.repaint();
                delta--;
            }
        }
    }
}
