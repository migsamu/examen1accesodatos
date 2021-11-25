package org.iesfm.examen1accesodatos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ScannerUtils {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final Scanner scan = new Scanner(System.in);

    public String askPath() {
        log.info("Introduce el path del directorio");
        return scan.nextLine();
    }

    public String askUsername() {
        log.info("Introduce el nombre de usuario");
        return scan.nextLine();
    }
}
