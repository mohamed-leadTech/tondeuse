package org.bj;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream file = FileInputHandler.readInputFile();
             Scanner scanner = new Scanner(file)) {

            int[] dimensionsPelouse = lireDimensionsPelouse(scanner);
            int maxX = dimensionsPelouse[0];
            int maxY = dimensionsPelouse[1];

            afficherDimensionsPelouse(maxX, maxY);

            IPelouse pelouse = new Pelouse(maxX, maxY);
            TondeuseManager tondeuseManager = new TondeuseManager(pelouse);

            lireEtAjouterTondeuses(scanner, tondeuseManager);
            afficherPositionsInitialesTondeuses(tondeuseManager);
            tondeuseManager.runInstructions();
            afficherPositionsFinalesTondeuses(tondeuseManager);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private static int[] lireDimensionsPelouse(Scanner scanner) {
        int maxX = 0;
        int maxY = 0;
        try {
            String[] pelouseDimensions = scanner.nextLine().split("\\s+");
            maxX = Integer.parseInt(pelouseDimensions[0]);
            maxY = Integer.parseInt(pelouseDimensions[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Erreur de parsing des dimensions de la pelouse", e);
        }
        return new int[]{maxX, maxY};
    }

    private static void afficherDimensionsPelouse(int maxX, int maxY) {
        System.out.println("Dimensions de la pelouse : " + maxX + " " + maxY);
    }

    private static void lireEtAjouterTondeuses(Scanner scanner, TondeuseManager tondeuseManager) {
        while (scanner.hasNextLine()) {
            try {
                String[] tondeuseInfos = scanner.nextLine().split("\\s+");
                int x = Integer.parseInt(tondeuseInfos[0]);
                int y = Integer.parseInt(tondeuseInfos[1]);
                Orientation orientation = Orientation.valueOf(tondeuseInfos[2]);
                ITondeuse tondeuse = new Tondeuse(x, y, orientation);
                String instructions = scanner.nextLine();
                tondeuse.setInstructions(instructions);
                tondeuseManager.addTondeuse(tondeuse);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Erreur lors de la lecture des informations de la tondeuse", e);
            }
        }
    }

    private static void afficherPositionsFinalesTondeuses(TondeuseManager tondeuseManager) {
        System.out.println("\nLes position finales des tondeuses....");
        IntStream.rangeClosed(1, tondeuseManager.getTondeuses().size())
                .forEach(i -> System.out.println("Tondeuse " + i + " : " + tondeuseManager.getTondeuses().get(i - 1).getPositionFinale()));
    }

    private static void afficherPositionsInitialesTondeuses(TondeuseManager tondeuseManager) {
        System.out.println("\nLes positions initiales des tondeuses et leurs instructions...");
        IntStream.rangeClosed(1, tondeuseManager.getTondeuses().size())
                .forEach(i -> System.out.println("Tondeuse " + i + " : " + tondeuseManager.getTondeuses().get(i - 1).getPositionFinale()+ " -> " +tondeuseManager.getTondeuses().get(i - 1).getInstructions()));
    }
}
