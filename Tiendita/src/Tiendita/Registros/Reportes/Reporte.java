package Tiendita.Registros.Reportes;

import Tiendita.Objetos.Factura;
import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import Tiendita.TDA.Simple.ColaPrioridad;
import Tiendita.TDA.Simple.ListaCircularSimple;
import Tiendita.TDA.Simple.ListaSimple;
import Tiendita.Objetos.Oferta;
import Tiendita.Registros.RegistroFactura;

public class Reporte {

    private static Reporte instancia;
    private ListaSimple<Usuario> usuario;
    private ListaCircularSimple<Producto> producto;
    private ColaPrioridad<Oferta> oferta;

    private Reporte() {
        this.usuario = new ListaSimple<>();
        this.producto = new ListaCircularSimple<>();
        this.oferta = new ColaPrioridad<>();
    }

    public static Reporte getReporte() {
        if (instancia == null) {
            instancia = new Reporte();
        }
        return instancia;
    }

    public ListaSimple<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(ListaSimple<Usuario> usuario) {
        this.usuario = usuario;
    }

    public ListaCircularSimple<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ListaCircularSimple<Producto> producto) {
        this.producto = producto;
    }

    public ColaPrioridad<Oferta> getOferta() {
        return oferta;
    }

    public void setOferta(ColaPrioridad<Oferta> oferta) {
        this.oferta = oferta;
    }

    public String reporteOferta() {
        String cadena = "<html>\n<body>\n<center>\n<Table border=\"1\">\n";
        for (int i = 0; i < oferta.getSize(); i++) {
            Oferta nuevaOferta;
            try {
                cadena += "<tr>\n<td>\nOferta " + (i + 1) + "</td>\n";
                nuevaOferta = oferta.search(i);
                for (int j = 0; j < nuevaOferta.getLista().getSize(); j++) {
                    cadena += "<td>";
                    Producto nuevoProducto = nuevaOferta.getLista().search(j);
                    cadena += nuevoProducto.getNombre() + "</td>\n";
                }
                cadena += "</tr>\n";
            } catch (Exception e) {
            }
        }
        cadena += "</table>\n</center>\n</body>\n</htmml>";
        return cadena;
    }

    public String reporteFactura() {
        String cadena = "<html>\n<body>\n<center>\n<Table border=\"1\">\n";
        RegistroFactura.getInstancia().ordenar();
        for (int i = 0; i < RegistroFactura.getInstancia().getFactura().getSize(); i++) {
            Factura nuevaFactura;
            try {
                nuevaFactura = RegistroFactura.getInstancia().getFactura().search(i);
                cadena += "<tr>\n<td>\nFactura " + nuevaFactura.getId() + "</td>\n";
                cadena += "<td>" + nuevaFactura.getNombre() + "</td>\n";
                cadena += "<td>" + nuevaFactura.getNit() + "</td>\n";
                cadena += "<td>No. de productos " + nuevaFactura.getProducto().getSize() + "</td>\n";
                cadena += "<td>" + nuevaFactura.getTotal() + "</td>\n";

            } catch (Exception e) {
            }
        }
        cadena += "</table>\n</center>\n</body>\n</htmml>";
        return cadena;
    }

    public String reporteUsuario() {
        String cadena = "<html>\n<body>\n<center>\n<Table border=\"1\">\n";
        for (int i = 0; i < usuario.getSize(); i++) {
            try {
                Usuario u = usuario.search(i);
                cadena += "<tr>\n";
                cadena += "<td>" + u.getNombre() + "</td>\n";
                for (int j = 0; j < 10; j++) {
                    Producto p = u.getCarrito().search(j);
                    cadena += "<td>" + p.getNombre() + "</td>\n";
                }
                cadena += "</tr>\n";
            } catch (Exception e) {
            }
        }
        cadena += "</table>\n</center>\n</body>\n</htmml>";
        return cadena;
    }
}
