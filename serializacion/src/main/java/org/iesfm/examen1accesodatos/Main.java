package org.iesfm.examen1accesodatos;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(Main.class.getResource("/hospital.json").toURI());
            Hospital hospital = mapper.readValue(file, Hospital.class);
            hospital.getInfo();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
