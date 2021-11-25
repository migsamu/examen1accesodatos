package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Room {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private int number;
    @JsonProperty("class")
    private String type;
    private List<String> patients;

    @JsonCreator
    public Room(
            @JsonProperty("number") int number,
            @JsonProperty("class") String type,
            @JsonProperty("patients") List<String> patients) {
        this.number = number;
        this.type = type;
        this.patients = patients;
    }

    public void getInfo() {
        log.info("ROOM: ");
        log.info("Numero: " + number);
        log.info("Clase: " + type);
        for (String patient : patients) {
            log.info(patient);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getPatients() {
        return patients;
    }

    public void setPatients(List<String> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number && Objects.equals(type, room.type) && Objects.equals(patients, room.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, patients);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", patients=" + patients +
                '}';
    }
}
