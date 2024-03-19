package org.bj;

public interface ITondeuse {

    void avancer(IPelouse pelouse);
    void tournerDroite();
    void tournerGauche();
    int getPositionX();
    int getPositionY();
   Orientation getOrientation();

    void setInstructions(String instructions);

    String getInstructions();

    void executeInstructions(IPelouse pelouse);

    String getPositionFinale();
    }
