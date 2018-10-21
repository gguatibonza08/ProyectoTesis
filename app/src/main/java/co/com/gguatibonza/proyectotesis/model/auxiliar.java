package co.com.gguatibonza.proyectotesis.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class auxiliar extends RealmObject {

    @PrimaryKey
    private int id;
    private int idUsuario;
    private int idMunicipio;
    private boolean logueado;


    public auxiliar() {
    }

    public auxiliar(int id, int idUsuario, int idMunicipio, boolean logueado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idMunicipio = idMunicipio;
        this.logueado = logueado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
}
