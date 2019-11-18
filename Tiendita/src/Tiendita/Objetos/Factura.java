package Tiendita.Objetos;

import Tiendita.TDA.Doble.ListaCircularDoble;

public class Factura {

    private int id;
    private String nombre;
    private String nit;
    private String tipo;
    private String direccion;
    private String tarjeta;
    private double total;
    private ListaCircularDoble<Producto> producto;

    public Factura(int id, String nombre, String nit, String tipo, String direccion, String tarjeta, double total, ListaCircularDoble<Producto> producto) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.tipo = tipo;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.total = total;
        this.producto = producto;
    }

    public Factura(int id, String nombre, String nit, String tipo, String direccion, String tarjeta, double total) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.tipo = tipo;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.total = total;
        this.producto = new ListaCircularDoble<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ListaCircularDoble<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ListaCircularDoble<Producto> producto) {
        this.producto = producto;
    }

}
