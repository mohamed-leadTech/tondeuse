package org.bj;

import java.util.ArrayList;
import java.util.List;

public class TondeuseManager {
    private final List<ITondeuse> tondeuses = new ArrayList<>();
    private final IPelouse pelouse;

    public TondeuseManager(IPelouse pelouse) {
        this.pelouse = pelouse;
    }

    public void addTondeuse(ITondeuse tondeuse) {
        tondeuses.add(tondeuse);
    }

    public void runInstructions() {
        for (ITondeuse tondeuse : tondeuses) {
            tondeuse.executeInstructions(pelouse);
        }
    }
    public List<ITondeuse> getTondeuses() {
        return tondeuses;
    }
}
