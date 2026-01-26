package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	GamePanel gp = new GamePanel();

	public GameWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(gp);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		gp.startGameThread();
	}
}