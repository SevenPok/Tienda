package Tiendita.Objetos;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    public static void graficar(String cadena, String nombre) {
        String archivo = nombre + ".dot";
        try {
            FileWriter fichero = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fichero);
            pw.println("digraph G {\n");
            pw.println(cadena);
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot.exe -Tpng " + nombre + ".dot -o " + nombre + ".png";
            Runtime.getRuntime().exec(cmd);
            File path = new File(nombre + ".png");
            Desktop.getDesktop().open(path);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static String crearHTML(String contenido) {
        String[] html = {"<html>\n", "<body>\n", "</body>\n", "</html>\n"};
        contenido += "\n";
        String cadena = html[0] + html[1] + contenido + html[2] + html[3];
        return cadena;
    }

    public static void escribirArchivo(String contenido, String ruta) {
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            JOptionPane.showMessageDialog(null, "Se creo exitosamente");
            File path = new File(ruta);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
        }

    }
}
