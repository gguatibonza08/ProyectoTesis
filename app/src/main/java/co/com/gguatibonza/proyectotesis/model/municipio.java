package co.com.gguatibonza.proyectotesis.model;

import java.io.Serializable;
import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class municipio extends RealmObject implements Serializable {

    @PrimaryKey
    private String nombre;
    private String descripcionBasica;
    private String descripcionCompleta;
    private ArrayList<String> simbolos;
    private String foto;

    public municipio(String nombre, String descripcionBasica, String descripcionCompleta, ArrayList<String> simbolos, String foto) {
        this.nombre = nombre;
        this.descripcionBasica = descripcionBasica;
        this.descripcionCompleta = descripcionCompleta;
        this.simbolos = simbolos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionBasica() {
        return descripcionBasica;
    }

    public void setDescripcionBasica(String descripcionBasica) {
        this.descripcionBasica = descripcionBasica;
    }

    public String getDescripcionCompleta() {
        return descripcionCompleta;
    }

    public void setDescripcionCompleta(String descripcionCompleta) {
        this.descripcionCompleta = descripcionCompleta;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}