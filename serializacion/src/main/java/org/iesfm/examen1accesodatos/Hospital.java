package org.iesfm.examen1accesodatos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Hospital {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    private String name;
    private int cp;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("creation_date")
    private Date creationDate;
    private List<Section> sections;

    @JsonCreator
    public Hospital(
            @JsonProperty("name") String name,
            @JsonProperty("cp") int cp,
            @JsonProperty("creation_date") Date creationDate,
            @JsonProperty("sections") List<Section> sections) {
        this.name = name;
        this.cp = cp;
        this.creationDate = creationDate;
        this.sections = sections;
    }

    public void getInfo() {

        log.info("HOSPITAL:");
        log.info("Nombre: " + name);
        log.info("cp: " + cp);
        log.info("Date: " + creationDate);
        for (Section section : sections) {
            section.getInfo();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return cp == hospital.cp && Objects.equals(name, hospital.name) && Objects.equals(creationDate, hospital.creationDate) && Objects.equals(sections, hospital.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cp, creationDate, sections);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", cp=" + cp +
                ", creationDate=" + creationDate +
                ", sections=" + sections +
                '}';
    }
}
