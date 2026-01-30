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

    private BufferedImage headUp, headDown, headLeft, headRight;
    private BufferedImage body, food;

    public GamePanel(GameState state) {
        this.state = state;
        loadSprites();
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyHandler(state));
    }
    
    public void resetGame() {
        state.reset();
    }

    private void loadSprites() {
        headUp = load("/res/Snake_Head_Up.png");
        headDown = load("/res/Snake_Head_Down.png");
        headLeft = load("/res/Snake_Head_Left.png");
        headRight = load("/res/Snake_Head_Right.png");
        body = load("/res/Body.png");
        food = load("/res/Food.png");
    }

    private BufferedImage load(String path) {
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + path);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawSnake(g);
        drawFood(g);

        if (state.isGameOver()) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 260, 300);
        }
    }

    private void drawSnake(Graphics g) {
        for (int i = 0; i < state.getSnake().size(); i++) {
            Point p = state.getSnake().get(i);

            if (i == 0) {
                BufferedImage head = switch (state.getDirection()) {
                    case 'U' -> headUp;
                    case 'D' -> headDown;
                    case 'L' -> headLeft;
                    default -> headRight;
                };
                g.drawImage(head, p.x * 25, p.y * 25, null);
            } else {
                g.drawImage(body, p.x * 25, p.y * 25, null);
            }
        }
    }

    private void drawFood(Graphics g) {
        Point f = state.getFood();
        g.drawImage(food, f.x * 25, f.y * 25, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(
            GameState.SCREEN_WIDTH,
            GameState.SCREEN_HEIGHT
        );
    }
}
