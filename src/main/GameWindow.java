package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

    GameState state;
    GamePanel gp;
    GameLoop loop;

    public GameWindow() {
        state = new GameState();
        gp = new GamePanel(state);
        loop = new GameLoop(gp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(gp);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loop.startGameThread();
    }
}
