package Tiendita.Registros;

import Tiendita.Objetos.Factura;
import Tiendita.Objetos.Producto;
import Tiendita.TDA.Simple.Nodo;
import Tiendita.TDA.Simple.Pila;

public class RegistroFactura {

    private static RegistroFactura instancia;
    private Pila<Factura> factura;

    private RegistroFactura() {
        factura = new Pila<>();
    }

    public static RegistroFactura getInstancia() {
        if (instancia == null) {
            instancia = new RegistroFactura();
        }
        return instancia;
    }

    public static void setInstancia(RegistroFactura instancia) {
        RegistroFactura.instancia = instancia;
    }

    public Pila<Factura> getFactura() {
        return factura;
    }

    public void setFactura(Pila<Factura> factura) {
        this.factura = factura;
    }

    public void ordenar() {
        for (int i = 0; i < (factura.getSize() - 1); i++) {
            Nodo<Factura> fin = factura.getCabeza();
            for (int j = 0; j < (factura.getSize() - 1); j++) {
                if (fin.getDato().getProducto().getSize() < fin.getNext().getDato().getProducto().getSize()) {
                    Factura nuevaFactura = fin.getNext().getDato();
                    fin.getNext().setDato(fin.getDato());
                    fin.setDato(nuevaFactura);
                }
                fin = fin.getNext();
            }
        }
    }
}
