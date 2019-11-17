package Tiendita.Registros;

import Tiendita.Objetos.EstablecerBotones;
import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Oferta;
import Tiendita.Objetos.Producto;
import Tiendita.TDA.Simple.ColaPrioridad;
import java.awt.Dimension;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistroOferta {

    private static RegistroOferta instancia;
    private ColaPrioridad<Oferta> ofertas;

    private RegistroOferta() {
        ofertas = new ColaPrioridad<>();
    }

    public static RegistroOferta getInstancia() {
        if (instancia == null) {
            instancia = new RegistroOferta();
        }
        return instancia;
    }

    public ColaPrioridad<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ColaPrioridad<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public void add(Oferta oferta) {
        ofertas.enqueue(oferta);
    }

    public void delete(int index) {
        try {
            ofertas.deleteIndex(index);

        } catch (Exception e) {
        }
    }

    public int tamanio() {
        return ofertas.getSize();
    }

    public void show(DefaultTableModel modelo, JTable tabla) {
        Object[] lista = ofertas.array();
        for (Object lista1 : lista) {
            JComboBox jc = new JComboBox();
            Oferta nuevoProducto = (Oferta) lista1;
            Object[] datos = new Object[4];
            datos[0] = nuevoProducto.getDescripcion();
            datos[1] = nuevoProducto.getDescuento() + "%";
            datos[2] = nuevoProducto.getPrioridad();
            for (int i = 0; i < nuevoProducto.getLista().getSize(); i++) {
                try {
                    jc.addItem(nuevoProducto.getLista().search(i).getNombre());
                } catch (Exception e) {
                }
            }
            datos[3] = jc;

            tabla.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(jc));
            tabla.setDefaultRenderer(Object.class, new Herramientas());
            modelo.addRow(datos);
        }

    }

    public int totalBoton() {
        Object[] lista = ofertas.array();
        int size = 0;
        for (int i = 0; i < lista.length; i++) {
            Object[] listaP = ((Oferta) lista[i]).getLista().array();
            size = size + listaP.length;
        }
        return size++;
    }

    public void productos(EstablecerBotones[] establecer, JButton[] boton, JLabel[] imagen, JLabel[] descripcion,
            JPanel panel, int x, int y, JButton pagar, JScrollPane scroll
    ) {
        int altura = (ofertas.getSize() / 2 + 1) * 215;
        panel.setPreferredSize(new Dimension(scroll.getWidth(), altura));
        Object[] lista = ofertas.array();
        establecer = new EstablecerBotones[100];
        boton = new JButton[100];
        imagen = new JLabel[100];
        descripcion = new JLabel[100];
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            Object[] listaP = ((Oferta) lista[i]).getLista().array();
            for (int j = 0; j < 10; j++) {
                try {

                    boton[contador] = new JButton("Agregar");
                    imagen[contador] = new JLabel();
                    descripcion[contador] = new JLabel("Antes Q." + String.format("%.2f", ((Producto) listaP[j]).getPrecio()) + " desc. " + String.format("%.2f", ((Oferta) lista[i]).getDescuento()) + "%");
                    establecer[contador] = new EstablecerBotones(boton[contador], imagen[contador], descripcion[contador], (Producto) listaP[j]);
                    establecer[contador].getImagen().setSize(150, 150);
                    establecer[contador].getDescripcion().setSize(150, 30);
                    establecer[contador].getBoton().setSize(150, 30);
                    Herramientas.setLabel(establecer[contador].getImagen(), ((Producto) listaP[j]).getDireccionImagen());
                    establecer[contador].getImagen().setLocation(x, y);
                    establecer[contador].getDescripcion().setLocation(x, y + 151);
                    establecer[contador].getBoton().setLocation(x, y + 180);

                    establecer[contador].action(pagar);

                    panel.add(establecer[contador].getBoton());
                    panel.add(establecer[contador].getImagen());
                    panel.add(establecer[contador].getDescripcion());
                    x = x + 155;
                    if (x > 600) {
                        x = 1;
                        y = y + 215;
                    }
                } catch (Exception e) {
                }
                contador++;
            }
        }

    }

}
