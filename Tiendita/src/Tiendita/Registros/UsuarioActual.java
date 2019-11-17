package Tiendita.Registros;

import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
            try {
                carrito[i] = (Producto) lista[i];
                JLabel lbl = new JLabel();
                lbl.setSize(75, 75);
                Herramientas.setLabel(lbl, carrito[i].getDireccionImagen());
                modelo.addRow(new Object[]{carrito[i].getNombre(), String.format("%.2f", carrito[i].getPrecio()), lbl});
            } catch (Exception e) {
            }

        }
    }

    public void pagar() {
        usuario.setArticulosCompradosGlobal(usuario.getArticulosCompradosGlobal() + usuario.getArticulosComprados());
        usuario.setArticulosComprados(0);
        usuario.getCarrito().vaciar();
        usuario.setTotal(0);
    }

    public void factura(DefaultTableModel modelo) {
        Object[] lista;
        lista = usuario.getCarrito().array();
        Producto factura[];
        factura = new Producto[usuario.getCarrito().getSize()];
        for (int i = 0; i < lista.length; i++) {
            try {
                factura[i] = (Producto) lista[i];
                Object[] dato = {factura[i].getNombre(), String.format("%.2f", factura[i].getPrecio())};
                modelo.addRow(dato);
            } catch (Exception e) {
            }
        }
    }

    public void deleteProducto(int index) {
        try {
            usuario.getCarrito().deleteIndex(index);
            usuario.setArticulosComprados(usuario.getArticulosComprados() - 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cancelar() {
        usuario.getCarrito().vaciar();
        usuario.setCanelaciones(usuario.getCanelaciones() + 1);
        usuario.setArticulosComprados(0);
    }
    
    
}
