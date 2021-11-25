package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Section {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private String name;
    private List<Room> rooms;

    @JsonCreator
    public Section(
            @JsonProperty("name") String name,
            @JsonProperty("rooms") List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void getInfo() {

        log.info("SECTION:");
        log.info("Nombre: " + name);
        for (Room room : rooms) {
            room.getInfo();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(name, section.name) && Objects.equals(rooms, section.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rooms);
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
