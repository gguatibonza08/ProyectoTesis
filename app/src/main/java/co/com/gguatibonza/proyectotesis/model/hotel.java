package co.com.gguatibonza.proyectotesis.model;

public class hotel {
    private String url;
    private String nombre;
    private String direccion;
    private String telefono;

    public hotel() {
    }

    public hotel(String url, String nombre, String direccion, String telefono) {
        this.url = url;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
