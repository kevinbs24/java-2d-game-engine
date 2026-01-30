package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private final GameState state;

    public KeyHandler(GameState state) {
        this.state = state;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char d = state.getDirection();

        if (e.getKeyCode() == KeyEvent.VK_W && d != 'D') state.setDirection('U');
        if (e.getKeyCode() == KeyEvent.VK_S && d != 'U') state.setDirection('D');
        if (e.getKeyCode() == KeyEvent.VK_A && d != 'R') state.setDirection('L');
        if (e.getKeyCode() == KeyEvent.VK_D && d != 'L') state.setDirection('R');

        if (e.getKeyCode() == KeyEvent.VK_ENTER && state.isGameOver()) {
            state.reset();
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
