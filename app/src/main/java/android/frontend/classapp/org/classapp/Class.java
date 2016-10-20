package android.frontend.classapp.org.classapp;

import java.util.Date;

/**
 * Created by Joseba Teré on 13/10/2016.
 */
public class Class {
    private Long id;
    private String name;
    private String description;
    private Date since;
    private Float latitude;
    private Float longitude;
    private Long iduser;

    public Class() {
    }

    public Class(Long id, String name, String description, Date since, Float latitude, Float longitude, Long iduser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.since = since;
        this.latitude = latitude;
        this.longitude = longitude;
        this.iduser = iduser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return " Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", since=" + since +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", iduser=" + iduser +
                '}';
    }
}
