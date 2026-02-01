package main;

public class Level {

    public final int rows;
    public final int cols;
    public final int brickWidth;
    public final int brickHeight;
    public final int spacing;
    public final int startX;
    public final int startY;

    public Level(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.brickWidth = 50;
        this.brickHeight = 20;
        this.spacing = 4;

        this.startX = 60;
        this.startY = 80;
    }
}
