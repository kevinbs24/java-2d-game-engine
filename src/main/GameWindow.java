package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    public GameWindow() {
        GameState state = new GameState();
        GamePanel panel = new GamePanel(state);
        GameLoop loop = new GameLoop(state, panel);

        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        loop.start();
    }
}
