package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	/*
	 * Every 2D game boils down to this loop: while (game is running) {
	 * processInput(); updateGameState(); render();}
	 */
	
	
	GameState state;

	public GamePanel(GameState state) {

		this.state = state;
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new KeyHandler(this));
	}
	
	public void resetGame() {
	    this.state = new GameState();
	}

	// paint displays data
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		state.draw(g);
	}

	/*
	 * pack() sizes the window based on preferred sizes, not constants. Swing never
	 * looks inside your fields. It only calls methods defined by the component
	 * contract.
	 */
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(
	        state.getScreenWidth(),
	        state.getScreenHeight()
	    );
	}
}
