package org.bj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseTest {

    IPelouse pelouse;

    @BeforeEach
    void setUp() {
        pelouse = new Pelouse(5, 5);
    }

    @Test
    void testerQueLaTondeuseExecuteCorrectementLesInstructions() {

        Tondeuse tondeuse = new Tondeuse(1, 2, Orientation.N);
        tondeuse.setInstructions("GAGAGAGAA");
        tondeuse.executeInstructions(pelouse);

        assertEquals(1, tondeuse.getPositionX());
        assertEquals(3, tondeuse.getPositionY());
        assertEquals(Orientation.N, tondeuse.getOrientation());
        assertEquals("1 3 N", tondeuse.getPositionFinale());
    }
    @Test
    void testerQueLaTondeuseNeBougeraPasSiLaPelouseNeLuiPermetPas() {
        Tondeuse tondeuse = new Tondeuse(0, 1, Orientation.N);
        String instructions = "GADAGAA";
        tondeuse.setInstructions(instructions);
        tondeuse.executeInstructions(pelouse);
        String expected = "0 2 W";
        assertEquals(expected,tondeuse.getPositionFinale());
    }
    @Test
    public void testerqueLaTondeuseAvanceVersLeNordSurAxeY() {
        Tondeuse tondeuse = new Tondeuse(0, 0, Orientation.N);

        tondeuse.avancer(pelouse);
        assertEquals(1, tondeuse.getPositionY());
        assertEquals(0, tondeuse.getPositionX());

    }

    @Test
    public void testerQueLaTondeuseAvanceVersEstSurAxeX() {
        Tondeuse tondeuse = new Tondeuse(1, 2, Orientation.E);

        tondeuse.avancer(pelouse);

        assertEquals(2, tondeuse.getPositionX());
        assertEquals(2, tondeuse.getPositionY());

    }

    @Test
    public void testerQueLaTondeuseAvanceVersLeSudSurAxeY() {
        Tondeuse tondeuse = new Tondeuse(1, 1, Orientation.S);

        tondeuse.avancer(pelouse);

        assertEquals(0, tondeuse.getPositionY());
        assertEquals(1, tondeuse.getPositionX());
    }

    @Test
    public void testerQueLaTondeuseAvanceVersOuestSurAxeX() {
        Tondeuse tondeuse = new Tondeuse(1, 1, Orientation.W);

        tondeuse.avancer(pelouse);

        assertEquals(0, tondeuse.getPositionX());
        assertEquals(1, tondeuse.getPositionY());

    }

    @Test
    void testerQueLaTondeuseSeTourneVersLaDroite() {
        // Given
        Tondeuse tondeuse = new Tondeuse(0, 0, Orientation.N);

        // When
        tondeuse.tournerDroite();

        // Check if the orientation is correctly updated to the right direction (East)
        assertEquals(Orientation.E, tondeuse.getOrientation());
    }

    @Test
    void testerQueLaTondeuseSeTourneVersLaGauche() {
        // Given
        Tondeuse tondeuse = new Tondeuse(0, 0, Orientation.N);

        // When
        tondeuse.tournerGauche();

        // Check if the orientation is correctly updated to the right direction (East)
        assertEquals(Orientation.W, tondeuse.getOrientation());
    }
}