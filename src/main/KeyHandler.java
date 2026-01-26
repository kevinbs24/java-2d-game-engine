package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		//Input does NOT move the snake, it only changes direction.
		if (e.getKeyCode() == KeyEvent.VK_W && gp.direction != 'D')
			gp.direction = 'U';
		if (e.getKeyCode() == KeyEvent.VK_S && gp.direction != 'U')
			gp.direction = 'D';
		if (e.getKeyCode() == KeyEvent.VK_A && gp.direction != 'R')
			gp.direction = 'L';
		if (e.getKeyCode() == KeyEvent.VK_D && gp.direction != 'L')
			gp.direction = 'R';
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
