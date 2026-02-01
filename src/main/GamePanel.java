package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private GameState state;

	public GamePanel(GameState state) {
		this.state = state;
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new KeyHandler(state.paddle));
	}

	public void resetGame() {
		state.reset();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if (state.ball.gameOver == true) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 260, 300);
		}
		
		state.paddle.draw(g);
		state.ball.draw(g);
		
		for (Brick b : state.bricks) {
		    if (!b.destroyed) {
		        g.setColor(Color.ORANGE);
		        g.fillRect(b.x, b.y, b.width, b.height);
		    }
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(GameState.SCREEN_WIDTH, GameState.SCREEN_HEIGHT);
	}
}
