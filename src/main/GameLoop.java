package main;

public class GameLoop implements Runnable {

    private final GameState state;
    private final GamePanel panel;

    public GameLoop(GameState state, GamePanel panel) {
        this.state = state;
        this.panel = panel;
    }

    @Override
    public void run() {
        final double fps = 60.0;
        final double nsPerFrame = 1_000_000_000.0 / fps;
        long last = System.nanoTime();
        double acc = 0;

        while (true) {
            long now = System.nanoTime();
            acc += (now - last) / nsPerFrame;
            last = now;

            while (acc >= 1) {
                state.update();
                panel.repaint();
                acc--;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {}
        }
    }
}
