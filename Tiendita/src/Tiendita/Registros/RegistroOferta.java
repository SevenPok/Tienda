package Tiendita.Registros;

import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Oferta;
import Tiendita.TDA.Simple.ColaPrioridad;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
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

    public void cargaMasiva() {

    }

}
