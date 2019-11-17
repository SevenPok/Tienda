package Tiendita.Registros;

import Tiendita.Objetos.Factura;
import Tiendita.Objetos.Producto;
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

}
