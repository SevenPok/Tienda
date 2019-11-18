package Tiendita.Registros;

import Tiendita.Objetos.EstablecerBotones;
import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import Tiendita.TDA.Simple.ListaCircularSimple;
import Tiendita.TDA.Simple.Nodo;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
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

    public ListaCircularSimple<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ListaCircularSimple<Producto> producto) {
        this.producto = producto;
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
            datos[2] = String.format("%.2f", nuevoProducto.getPrecio());
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
            datos[3] = String.format("%.2f", nuevo.getPrecio());
            datos[4] = nuevo.getExistencia();
            modelo.addRow(datos);
            String imagen = nuevo.getDireccionImagen();
            return imagen;
        } catch (Exception ex) {
            throw new Exception("");
        }

    }

    public void showCOmboBox(JComboBox box) {
        Object[] lista = producto.array();
        Producto nuevo;
        for (Object lista1 : lista) {
            nuevo = (Producto) lista1;
            box.addItem(nuevo.getNombre());
        }
    }

    public void productos(EstablecerBotones[] establecer, JButton[] boton, JLabel[] imagen, JLabel[] descripcion,
            JPanel panel, int x, int y, JButton pagar, JScrollPane scroll
    ) {
        int altura = (producto.getSize() / 4 + 1) * 215;
        panel.setPreferredSize(new Dimension(scroll.getWidth(), altura));
        Object[] lista = producto.array();
        establecer = new EstablecerBotones[lista.length];
        boton = new JButton[lista.length];
        imagen = new JLabel[lista.length];
        descripcion = new JLabel[lista.length];
        for (int i = 0; i < lista.length; i++) {
            boton[i] = new JButton("Agregar");
            imagen[i] = new JLabel();
            descripcion[i] = new JLabel(((Producto) lista[i]).getNombre() + " a Q." + String.format("%.2f", ((Producto) lista[i]).getPrecio()), SwingConstants.CENTER);
            establecer[i] = new EstablecerBotones(boton[i], imagen[i], descripcion[i], (Producto) lista[i]);
            establecer[i].getImagen().setSize(150, 150);
            establecer[i].getDescripcion().setSize(150, 30);
            establecer[i].getBoton().setSize(150, 30);
            Herramientas.setLabel(establecer[i].getImagen(), ((Producto) lista[i]).getDireccionImagen());
            establecer[i].getImagen().setLocation(x, y);
            establecer[i].getDescripcion().setLocation(x, y + 151);
            establecer[i].getBoton().setLocation(x, y + 180);

            establecer[i].action(pagar);

            panel.add(establecer[i].getBoton());
            panel.add(establecer[i].getImagen());
            panel.add(establecer[i].getDescripcion());
            x = x + 155;
            if (x > 600) {
                x = 1;
                y = y + 215;
            }
        }
    }

    public void ganancias(Usuario o) {
        for (int i = 0; i < o.getCarrito().getSize(); i++) {
            try {
                Producto p = o.getCarrito().search(i);
                p.setGanacias(p.getPrecio() + p.getGanacias());
            } catch (Exception e) {
            }
        }
    }

    public void ordenar() {
        for (int i = 0; i < (producto.getSize() - 1); i++) {
            Nodo<Producto> p = producto.getCabeza();
            for (int j = 0; j < (producto.getSize() - 1); j++) {
                if (p.getDato().getGanacias() < p.getNext().getDato().getGanacias()) {
                    Producto aux = p.getNext().getDato();
                    p.getNext().setDato(p.getDato());
                    p.setDato(aux);
                }
                p = p.getNext();
            }
        }
    }

}
