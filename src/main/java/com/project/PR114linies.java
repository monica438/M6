package com.project;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        Random random = new Random();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(camiFitxer),StandardCharsets.UTF_8)){
            for (int i = 0; i < 10; i++) {
                int numeroAleatori = random.nextInt(100); // Números entre 0 i 99
                writer.write(String.valueOf(numeroAleatori));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
