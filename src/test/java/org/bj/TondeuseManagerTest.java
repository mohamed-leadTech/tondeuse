package org.bj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseManagerTest {

    @Test
    void addTondeuse() {
    }

    @Test
    void runInstructions() {

        ITondeuse tondeuse1 = new Tondeuse(1, 2, Orientation.N);
        tondeuse1.setInstructions("GAGAGAGAA");
        ITondeuse tondeuse2 = new Tondeuse(3, 3, Orientation.E);
        tondeuse2.setInstructions("AADAADADDA");


        TondeuseManager tondeuseManager = new TondeuseManager(new Pelouse(5, 5));
        tondeuseManager.addTondeuse(tondeuse1);
        tondeuseManager.addTondeuse(tondeuse2);

        tondeuseManager.runInstructions();

        assertEquals(2, tondeuseManager.getTondeuses().size());
        assertEquals("1 3 N", tondeuse1.getPositionFinale());
        assertEquals("5 1 E", tondeuse2.getPositionFinale());

    }

}