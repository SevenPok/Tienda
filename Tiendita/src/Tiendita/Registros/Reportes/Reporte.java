package Tiendita.Registros.Reportes;

import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import Tiendita.TDA.Simple.ColaPrioridad;
import Tiendita.TDA.Simple.ListaCircularSimple;
import Tiendita.TDA.Simple.ListaSimple;
import Tiendita.Objetos.Oferta;

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
                cadena += "<tr>\n<td>\nOferta "+(i+1)+"</td>\n";
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

}
