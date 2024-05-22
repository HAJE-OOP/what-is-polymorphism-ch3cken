package org.haje.ducks;

import java.awt.*;

public abstract class Duck {
    protected int x;
    protected int y;

    public abstract void draw(Graphics2D g2d);

    public void ChangeX(int dx) {
        this.x += dx;
    }

    public void ChangeY(int dy) {
        this.y += dy;
    }
}
