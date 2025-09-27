package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(camiFitxer, StandardCharsets.UTF_8, true))) {
            writer.write("I can only show you the door");
            writer.newLine();
            writer.write("You're the one that has to walk through it");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
