package Tiendita.Registros;

import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class UsuarioActual {

    private static UsuarioActual instancia;
    private Usuario usuario;

    private UsuarioActual() {
        usuario = null;
    }

    public static UsuarioActual getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioActual();
        }
        return instancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void carrito(DefaultTableModel modelo, JTable tabla) {
        Object[] lista = usuario.getCarrito().array();
        Producto carrito[] = new Producto[usuario.getCarrito().getSize()];
        tabla.setDefaultRenderer(Object.class, new tabla());
        tabla.setRowHeight(75);
        for (int i = 0; i < 10; i++) {
            carrito[i] = (Producto) lista[i];
            JLabel lbl = new JLabel();
            lbl.setSize(75, 75);
            Herramientas.setLabel(lbl, carrito[i].getDireccionImagen());
            modelo.addRow(new Object[]{carrito[i].getNombre(), carrito[i].getPrecio(), lbl});
        }
    }

}
