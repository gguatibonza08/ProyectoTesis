package co.com.gguatibonza.proyectotesis.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class municipio extends RealmObject {

    @PrimaryKey
    private int idMunicipio;
    private String nombreMunicipio;
    private double longitudMunicipio;
    private double latitudMunicipio;
    private String descripcionBasicaMunicipio;
    private String descripcionLargaMunicipio;
    private String idInstagram;
    private String fotoMunicipio;

    public municipio() {
    }

    public municipio(int idMunicipio, String nombreMunicipio, double longitudMunicipio, double latitudMunicipio, String descripcionBasicaMunicipio, String descripcionLargaMunicipio, String idInstagram, String fotoMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.longitudMunicipio = longitudMunicipio;
        this.latitudMunicipio = latitudMunicipio;
        this.descripcionBasicaMunicipio = descripcionBasicaMunicipio;
        this.descripcionLargaMunicipio = descripcionLargaMunicipio;
        this.idInstagram = idInstagram;
        this.fotoMunicipio = fotoMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public double getLongitudMunicipio() {
        return longitudMunicipio;
    }

    public void setLongitudMunicipio(double longitudMunicipio) {
        this.longitudMunicipio = longitudMunicipio;
    }

    public double getLatitudMunicipio() {
        return latitudMunicipio;
    }

    public void setLatitudMunicipio(double latitudMunicipio) {
        this.latitudMunicipio = latitudMunicipio;
    }

    public String getDescripcionBasicaMunicipio() {
        return descripcionBasicaMunicipio;
    }

    public void setDescripcionBasicaMunicipio(String descripcionBasicaMunicipio) {
        this.descripcionBasicaMunicipio = descripcionBasicaMunicipio;
    }

    public String getDescripcionLargaMunicipio() {
        return descripcionLargaMunicipio;
    }

    public void setDescripcionLargaMunicipio(String descripcionLargaMunicipio) {
        this.descripcionLargaMunicipio = descripcionLargaMunicipio;
    }

    public String getIdInstagram() {
        return idInstagram;
    }

    public void setIdInstagram(String idInstagram) {
        this.idInstagram = idInstagram;
    }

    public String getFotoMunicipio() {
        return fotoMunicipio;
    }

    public void setFotoMunicipio(String fotoMunicipio) {
        this.fotoMunicipio = fotoMunicipio;
    }
}