package com.project;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR110ReadFile {
    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        try {
            int liniaNum = 1; // Numeració de línies (inicia a 1)
            // Per cada línea llegida del fitxer, imprimim el número de línia i el contingut
            List<String> linies = Files.readAllLines(Paths.get(camiFitxer), StandardCharsets.UTF_8);
            for (String linia : linies) { 
                System.out.println(liniaNum + ": " + linia);
                liniaNum++; // Incrementem el número de línia
            }    
        } catch (NoSuchFileException e) {
            System.out.println("El fitxer no existeix: " + camiFitxer);
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
