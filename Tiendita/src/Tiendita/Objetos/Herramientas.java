package Tiendita.Objetos;

import Tiendita.Registros.RegistroProducto;
import Tiendita.Registros.UsuarioActual;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Herramientas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JComboBox) {
            JComboBox jc = (JComboBox) value;
            return jc;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public static void setLabel(JLabel imagen, String ruta) {
        ImageIcon imgIcon = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
        imagen.setIcon(icono);
    }

}
