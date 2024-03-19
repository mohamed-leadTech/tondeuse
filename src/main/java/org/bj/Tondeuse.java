package org.bj;

public class Tondeuse implements ITondeuse {
    private int positionX;
    private int positionY;
    private Orientation orientation;
    private String instructions;

    public Tondeuse(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void executeInstructions(IPelouse pelouse) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D':
                    tournerDroite();
                    break;
                case 'G':
                    tournerGauche();
                    break;
                case 'A':
                    avancer(pelouse);
                    break;
            }
        }
    }

    public void avancer(IPelouse pelouse) {
        switch (orientation) {
            case N:
                if (pelouse.isInside(positionX, positionY + 1)) {
                    positionY++;
                }
                break;
            case E:
                if (pelouse.isInside(positionX + 1, positionY)) {
                    positionX++;
                }
                break;
            case S:
                if (pelouse.isInside(positionX, positionY - 1)) {
                    positionY--;
                }
                break;
            case W:
                if (pelouse.isInside(positionX - 1, positionY)) {
                    positionX--;
                }
                break;
        }
    }

    @Override
    public void tournerDroite() {
        orientation = orientation.tournerDroite();
    }

    @Override
    public void tournerGauche() {
        orientation = orientation.tournerGauche();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getPositionFinale() {
        return positionX + " " + positionY + " " + orientation;
    }

    public String getInstructions() {
        return instructions;
    }
}