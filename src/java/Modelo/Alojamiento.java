
package Modelo;


public class Alojamiento {
    private int idAlojamiento;
    private String nombre;
    private String descripcion;
    private int capacidad;
    private double precio;
    private String rutaFoto;
    
    public Alojamiento(){}
    
    public Alojamiento(int idAlojamiento, String nombre, String descripcion, int capacidad, double precio, String rutaFoto){
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
        this.rutaFoto = rutaFoto;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
