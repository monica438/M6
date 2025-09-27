package com.project;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        File fitxer = new File(rutaArxiu);

        if (!fitxer.exists() || !fitxer.canRead()) {
            System.out.println("El fitxer no existeix o no és accessible.");
        } else if (fitxer.isDirectory()) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        } else {
            try {
                List<String> linies = Files.readAllLines(fitxer.toPath(), StandardCharsets.UTF_8);
                for (String linia : linies) {
                    System.out.println(linia);
                }
            } catch (IOException e) {
                System.out.println("El fitxer no existeix o no és accessible.");
            }
        } 
    }
}
