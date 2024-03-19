package org.bj;

public enum Orientation {
    N, E, S, W;

    public Orientation tournerDroite() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Orientation tournerGauche() {
        return values()[(ordinal() + 3) % values().length];
    }
}
