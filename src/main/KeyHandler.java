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
		if (e.getKeyCode() == KeyEvent.VK_W && gp.state.getDirection() != 'D')
			gp.state.setDirection('U');
		if (e.getKeyCode() == KeyEvent.VK_S && gp.state.getDirection() != 'U')
			gp.state.setDirection('D');
		if (e.getKeyCode() == KeyEvent.VK_A && gp.state.getDirection() != 'R')
			gp.state.setDirection('L');
		if (e.getKeyCode() == KeyEvent.VK_D && gp.state.getDirection() != 'L')
			gp.state.setDirection('R');
		if (e.getKeyCode() == KeyEvent.VK_ENTER && gp.state.isGameOver()) {
		    gp.resetGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
