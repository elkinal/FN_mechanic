package Main;

import java.awt.image.BufferedImage;

/**
 * Created by alxye on 17-Jul-18.
 */
public class Player {
    private int x; //center location
    private int y;
    private int size;
    private BufferedImage skin;

    public Player(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getSkin() {
        return skin;
    }

    public void setSkin(BufferedImage skin) {
        this.skin = skin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
