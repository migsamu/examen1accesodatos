package org.iesfm.examen1accesodatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public void listFilesandSearch(String path, String username) {
        File folder = new File(path);
        File usernameFile = new File(path + "/" + username + ".txt");
        boolean encontrado = false;
        for (File file : folder.listFiles()) {
            log.info(file.getName());
            if (file.getName().equals(username + ".txt")) {
                writeFile(file, "Ya existía");
                encontrado = true;
            }
        }
        if (encontrado == false) {
            writeFile(usernameFile, "Creado");
        }
    }


    public void writeFile(File file, String message) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
