package org.iesfm.examen1accesodatos;

public class Main {
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        ScannerUtils scannerUtils = new ScannerUtils();

        String path = scannerUtils.askPath();
        String username = scannerUtils.askUsername();

        fileUtils.listFilesandSearch(path, username);
    }
}
