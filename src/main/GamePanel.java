package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
		
		state.paddle.draw(g);

		state.ball.draw(g);

		if (state.isGameOver()) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 260, 300);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(GameState.SCREEN_WIDTH, GameState.SCREEN_HEIGHT);
	}
}
