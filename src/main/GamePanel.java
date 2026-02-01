package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private final GameState state;

    public GamePanel(GameState state) {
        this.state = state;
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyHandler(state));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!state.ball.gameOver) {
        state.paddle.draw(g);
        state.ball.draw(g);
        }

        for (Brick b : state.bricks) {
            if (!b.destroyed) {
                g.setColor(Color.ORANGE);
                g.fillRect(b.x, b.y, b.width, b.height);
            }
        }

        if (state.ball.gameOver) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER - PRESS ENTER", 220, 300);
            state.bricks.clear();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(
            GameState.SCREEN_WIDTH,
            GameState.SCREEN_HEIGHT
        );
    }
}
