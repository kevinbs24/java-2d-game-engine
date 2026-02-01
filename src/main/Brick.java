package main;

public class Brick {

    public int x, y;
    public final int width = 50;
    public final int height = 20;
    public boolean destroyed = false;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
