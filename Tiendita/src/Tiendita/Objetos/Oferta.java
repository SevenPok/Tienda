package Tiendita.Objetos;

import Tiendita.Objetos.Prototype.Clonar;
import Tiendita.TDA.Simple.ListaSimple;

public class Oferta implements Clonar {

    private String descripcion;
    private double descuento;
    private ListaSimple<Producto> lista;
    private String prioridad;

    public Oferta(String descripcion, double descuento, ListaSimple<Producto> lista, String prioridad) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.lista = lista;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public ListaSimple<Producto> getLista() {
        return lista;
    }

    public void setLista(ListaSimple<Producto> lista) {
        this.lista = lista;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public Clonar clonar() {
        Oferta oferta = null;
        try {
            oferta = (Oferta) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return oferta;
    }

}
