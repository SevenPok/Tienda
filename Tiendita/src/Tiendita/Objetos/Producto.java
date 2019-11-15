package Tiendita.Objetos;

public class Producto {

    private int identificador;
    private String nombre;
    private String descripcion;
    private double precio;
    private int existencia;
    private String direccionImagen;

    public Producto(int identificador, String nombre, String descripcion, double precio, int existencia, String direccionImagen) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.direccionImagen = direccionImagen;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public boolean existencia() {
        return existencia > 0;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    @Override
    public String toString() {
        return "identificador=" + identificador + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", existencia=" + existencia + ", direccionImagen=" + direccionImagen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto) {
            Producto p = (Producto) obj;
            return this.nombre.equalsIgnoreCase(p.nombre);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.identificador;
        return hash;
    }

}
