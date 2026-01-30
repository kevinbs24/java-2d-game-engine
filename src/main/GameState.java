package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class GameState {

    public static final int TILE_SIZE = 25;
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;

    private boolean gameOver = false;
    private char direction = 'R';

    private Point food;
    private final ArrayList<Point> snake = new ArrayList<>();
    private final Random random = new Random();

    public GameState() {
        snake.add(new Point(5, 5));
        spawnFood();
    }
    
    public void reset() {
        gameOver = false;
        direction = 'R';
        snake.clear();
        snake.add(new Point(5, 5));
        spawnFood();
    }

    public void update() {
        if (gameOver) return;

        Point head = snake.get(0);
        Point newHead = new Point(head);

        switch (direction) {
            case 'U' -> newHead.y--;
            case 'D' -> newHead.y++;
            case 'L' -> newHead.x--;
            case 'R' -> newHead.x++;
        }

        // Wall collision
        if (newHead.x < 0 || newHead.y < 0 ||
            newHead.x >= SCREEN_WIDTH / TILE_SIZE ||
            newHead.y >= SCREEN_HEIGHT / TILE_SIZE) {
            gameOver = true;
            return;
        }

        // Self collision
        for (Point p : snake) {
            if (newHead.equals(p)) {
                gameOver = true;
                return;
            }
        }

        snake.add(0, newHead);

        if (newHead.equals(food)) {
            spawnFood();
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    private void spawnFood() {
        int maxX = SCREEN_WIDTH / TILE_SIZE;
        int maxY = SCREEN_HEIGHT / TILE_SIZE;

        while (true) {
            Point p = new Point(random.nextInt(maxX), random.nextInt(maxY));
            if (!snake.contains(p)) {
                food = p;
                break;
            }
        }
    }

    // ===== Getters / setters =====

    public ArrayList<Point> getSnake() {
        return snake;
    }

    public Point getFood() {
        return food;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
