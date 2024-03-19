package org.bj;

public class Pelouse implements IPelouse {
    private final int maxX;
    private final int maxY;

    public Pelouse(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    @Override
    public String toString() {
        return "Pelouse{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }
}