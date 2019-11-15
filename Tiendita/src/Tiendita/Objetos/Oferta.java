package Tiendita.Objetos;

import Tiendita.TDA.Simple.ListaSimple;

public class Oferta {

    private String descripcion;
    private double descuento;
    private ListaSimple<String> lista;
    private String prioridad;

    public Oferta(String descripcion, double descuento, ListaSimple<String> lista, String prioridad) {
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

    public ListaSimple<String> getLista() {
        return lista;
    }

    public void setLista(ListaSimple<String> lista) {
        this.lista = lista;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
