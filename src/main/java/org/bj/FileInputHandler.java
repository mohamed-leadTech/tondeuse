package org.bj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class FileInputHandler {
    public static FileInputStream readInputFile() {
        return getPathFromUserInput()
                .map(FileInputHandler::getFileInputStream)
                .orElseGet(FileInputHandler::getDefaultFile);
    }

    private static Optional<String> getPathFromUserInput() {
        System.out.println("Veuillez entrer le chemin du fichier d'instruction.");
        try (Scanner stringScanner = new Scanner(System.in)) {
            return Optional.of(stringScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage() + "\nNous allons récupérer un fichier par défaut.");
            return Optional.empty();
        }
    }

    private static FileInputStream getFileInputStream(String chemin) {
        try {
            return new FileInputStream(chemin);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur: " + e.getMessage() + "\nNous allons récupérer un fichier par défaut.");
            return getDefaultFile();
        }
    }

    private static FileInputStream getDefaultFile() {
        try {
            String path = Optional.ofNullable(Main.class.getClassLoader().getResource("input.txt"))
                    .map(Object::toString)
                    .map(s -> s.replace("file:\\", "").replace("file:/", ""))
                    .orElseThrow(() -> new FileNotFoundException("Fichier par défaut introuvable"));
            return new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur: Impossible de récupérer le fichier par défaut.");
            e.printStackTrace();
            return null;
        }
    }
}
