package com.project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {

        //Creo un objecte Path que apunta a una carpeta
        Path carpeta = Paths.get(camiFitxer, "myFiles");

        // Comprovo si la carpeta existeix, si no existeix la creo
        if (Files.notExists(carpeta)) {
            try {
                Files.createDirectory(carpeta);
            } catch (IOException e) {
                System.err.println("Error creant la carpeta: " + e.getMessage());
                return;
            }
        }

        // Creo dos fitxers dins la carpeta
        Path file1 = carpeta.resolve("file1.txt");
        Path file2 = carpeta.resolve("file2.txt");

        try {
            Files.createFile(file1);
        } catch (FileAlreadyExistsException e) {
            System.out.println("El fitxer 'file1.txt' ja existeix.");
        } catch (IOException e) {
            System.err.println("Error creant 'file1.txt': " + e.getMessage());
        }

        try {
            Files.createFile(file2);
        } catch (FileAlreadyExistsException e) {
            System.out.println("El fitxer 'file2.txt' ja existeix.");
        } catch (IOException e) {
            System.err.println("Error creant 'file2.txt': " + e.getMessage());
        }

        // Renombro "file2.txt" a "renamedFile.txt"
        Path renamedFile = carpeta.resolve("renamedFile.txt");
        try {
            Files.move(file2, renamedFile);
        } catch (IOException e) {
            System.err.println("Error renombrant 'file2.txt': " + e.getMessage());
        }

        // Mostro els arxius de la carpeta
        try {
            System.out.println("Els arxius de la carpeta són:");
            Files.list(carpeta).forEach(path -> System.out.println(path.getFileName()));
        }
        catch (Exception e) {
            System.err.println("Error mostrant els arxius: " + e.getMessage());
        }
        
    }
}