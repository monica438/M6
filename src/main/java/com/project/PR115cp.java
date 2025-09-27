package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        Path origen = Paths.get(rutaOrigen);
        Path desti = Paths.get(rutaDesti);
        
        if (!Files.exists(origen) || !rutaOrigen.endsWith(".txt")) {
            System.out.println("L'arxiu d'origen no existeix o no és un arxiu de text.");
            return;
        } else {
            if (Files.exists(desti)) {
                System.out.println("L'arxiu de destinació ja existeix. Es reescriurà.");
            }
        }

        try {
            Files.copy(origen, desti, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arxiu copiat correctament de " + rutaOrigen + " a " + rutaDesti);
        } catch (IOException e) {
            System.out.println("Error en copiar l'arxiu: " + e.getMessage());
        }
    }
}
