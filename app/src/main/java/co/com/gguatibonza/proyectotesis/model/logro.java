package co.com.gguatibonza.proyectotesis.model;

public class logro {
    private String nombreLogro;
    private String fotoLogro;

    public logro(){
    }

    public logro(String nombreLogro, String fotoLogro){
        this.nombreLogro = nombreLogro;
        this.fotoLogro = fotoLogro;
    }

    public String getNombreLogro() {
        return nombreLogro;
    }

    public String getFotoLogro() {
        return fotoLogro;
    }

    public void setNombreLogro(String nombreLogro) {
        this.nombreLogro = nombreLogro;
    }

    public void setFotoLogro(String fotoLogro) {
        this.fotoLogro = fotoLogro;
    }
}
