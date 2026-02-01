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
        if (e.getKeyCode() == KeyEvent.VK_A)
            state.paddle.moveLeft();

        if (e.getKeyCode() == KeyEvent.VK_D)
            state.paddle.moveRight();

       if (e.getKeyCode() == KeyEvent.VK_ENTER && state.ball.gameOver)
            state.reset();
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
