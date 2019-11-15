package Tiendita.Registros;

import Tiendita.Objetos.Producto;
import Tiendita.TDA.Simple.ListaCircularSimple;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class RegistroProducto implements Registro<Producto> {

    private static RegistroProducto registroProducto;
    private ListaCircularSimple<Producto> producto;

    private RegistroProducto() {
        producto = new ListaCircularSimple<>();
    }

    public static RegistroProducto getRegistroProducto() {
        if (registroProducto == null) {
            registroProducto = new RegistroProducto();
        }
        return registroProducto;
    }

    @Override
    public boolean add(Producto dato) {
        return producto.add(dato);
    }

    @Override
    public void modify(Producto dato) {
        producto.modify(dato);
    }

    @Override
    public Producto search(Producto dato) throws Exception {
        try {
            return producto.search(dato).getDato();

        } catch (Exception e) {
            throw e;
        }
    }

    public Producto search(int index) throws Exception {
        return producto.search(index);
    }

    @Override
    public Producto delete(Producto dato) throws Exception {
        try {
            return producto.delete(dato);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void cargaMasiva(String cadena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show(DefaultTableModel modelo) {
        Object[] lista = producto.array();
        for (int i = 0; i < lista.length; i++) {
            Producto nuevoProducto = (Producto) lista[i];
            Object[] datos = new Object[3];
            datos[0] = nuevoProducto.getIdentificador();
            datos[1] = nuevoProducto.getNombre();
            datos[2] = nuevoProducto.getPrecio();
            modelo.addRow(datos);
        }
    }

    public void showTienda(JLabel[] imagen, JButton[] boton) {
        Object[] lista = producto.array();
        imagen = new JLabel[lista.length];
        boton = new JButton[lista.length];
        for (int i = 0; i < lista.length; i++) {
            Producto nuevoProducto = (Producto) lista[i];
            boton[i] = new JButton("Agregar");
            imagen[i] = new JLabel();
            imagen[i].setSize(150, 150);
            boton[i].setSize(150, 35);
            ImageIcon imgIcon = new ImageIcon(nuevoProducto.getDireccionImagen());
            Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(imagen[i].getWidth(), imagen[i].getHeight(), Image.SCALE_SMOOTH));
            imagen[i].setIcon(icono);
        }

    }

    public String showEspecifico(DefaultTableModel modelo, int index) throws Exception {
        try {
            Producto nuevo = producto.search(index);
            Object[] datos = new Object[5];
            datos[0] = nuevo.getIdentificador();
            datos[1] = nuevo.getNombre();
            datos[2] = nuevo.getDescripcion();
            datos[3] = nuevo.getPrecio();
            datos[4] = nuevo.getExistencia();
            modelo.addRow(datos);
            String imagen = nuevo.getDireccionImagen();
            return imagen;
        } catch (Exception ex) {
            throw new Exception("");
        }

    }
}
