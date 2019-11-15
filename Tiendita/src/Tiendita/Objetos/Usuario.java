package Tiendita.Objetos;

import Tiendita.TDA.Doble.ListaCircularDoble;
import java.util.Objects;

public class Usuario implements Descuento {

    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private Tarjeta tarjeta;
    private ListaCircularDoble<Producto> carrito;
    private int articulosComprados;
    private double total;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String nombre, String apellido, Tarjeta tarjeta) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjeta = tarjeta;
        this.carrito = new ListaCircularDoble<>();
        this.articulosComprados = 0;
        this.total = 0;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ListaCircularDoble<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ListaCircularDoble<Producto> carrito) {
        this.carrito = carrito;
    }

    public int getArticulosComprados() {
        return articulosComprados;
    }

    public void setArticulosComprados(int articulosComprados) {
        this.articulosComprados = articulosComprados;
    }

    public double getTotal() {
        total = 0;
        Object[] car = carrito.array();
        for (int i = 0; i < carrito.getSize(); i++) {
            Producto nuevo = (Producto) car[i];
            total = total + nuevo.getPrecio();
        }
        return total;
    }

    public void setTotal(double total) {

        this.total = total;
    }

    @Override
    public String toString() {
        return "Usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", tarjeta=" + tarjeta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario u = (Usuario) obj;
            return this.usuario.equalsIgnoreCase(u.usuario);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.password);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellido);
        hash = 17 * hash + Objects.hashCode(this.tarjeta);
        hash = 17 * hash + Objects.hashCode(this.carrito);
        hash = 17 * hash + this.articulosComprados;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public int descuento() {
        int descuento = 0;
        if (articulosComprados >= 15 && articulosComprados < 30) {
            descuento = 2;
        } else if (articulosComprados >= 30 && articulosComprados < 45) {
            descuento = 4;
        } else if (articulosComprados >= 45 && articulosComprados < 60) {
            descuento = 6;
        } else if (articulosComprados >= 60 && articulosComprados < 75) {
            descuento = 8;
        } else if (articulosComprados >= 75) {
            descuento = 10;
        }
        return descuento / 100;
    }

}
