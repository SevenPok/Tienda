package Tiendita.Objetos;

import Tiendita.Registros.UsuarioActual;
import Tiendita.Ventanas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EstablecerBotones {

    private JButton boton;
    private JLabel imagen;
    private JLabel descripcion;
    private Producto producto;

    public EstablecerBotones(JButton boton, JLabel imagen, JLabel descripcion, Producto producto) {
        this.boton = boton;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JLabel getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JLabel descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void action(JButton carrito) {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int salir = JOptionPane.showConfirmDialog(null, "¿Quiere agregar este producto?", "Agregar!", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == salir) {
                    Usuario usuario = UsuarioActual.getInstancia().getUsuario();
                    usuario.getCarrito().addFin(producto);
                    usuario.setArticulosComprados(usuario.getArticulosComprados() + 1);
                    usuario.setArticulosCompradosGlobal(usuario.getArticulosCompradosGlobal() + 1);
                    carrito.setText("(" + usuario.getArticulosComprados() + ")  Q " + String.format("%.2f", usuario.getTotal()));
                }
            }
        });
    }

}
