package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	Paddle paddle;
	
	public KeyHandler(Paddle paddle) {
		
		this.paddle = paddle;
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_A) paddle.moveLeft();
        if (e.getKeyCode() == KeyEvent.VK_D) paddle.moveRight();
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
