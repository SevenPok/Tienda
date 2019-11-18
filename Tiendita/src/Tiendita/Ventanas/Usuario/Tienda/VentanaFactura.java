package Tiendita.Ventanas.Usuario.Tienda;

import Tiendita.Objetos.Factura;
import Tiendita.Objetos.Producto;
import Tiendita.Objetos.Usuario;
import Tiendita.Registros.Registro;
import Tiendita.Registros.RegistroFactura;
import Tiendita.Registros.RegistroProducto;
import Tiendita.Registros.RegistroUsuario;
import Tiendita.Registros.Reportes.Reporte;
import Tiendita.Registros.UsuarioActual;
import Tiendita.TDA.Doble.ListaCircularDoble;
import Tiendita.TDA.Doble.Nodo;
import Tiendita.Ventanas.Usuario.UsuarioPrincipal;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VentanaFactura extends javax.swing.JFrame {

    private static int correlativo = 1;
    private DefaultTableModel modelo = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VentanaFactura() {
        initComponents();
        contenidoTable();
        contenidoLabel();
        contenidoText();
    }

    //Estabelcemos los datos de la tabla
    private void contenidoTable() {
        this.modelo.addColumn("Producto");
        this.modelo.addColumn("Precio");
        TableColumn columna = jTableProductos.getColumn("Producto");
        TableColumn columna2 = jTableProductos.getColumn("Precio");
        columna.setPreferredWidth(90);
        columna2.setPreferredWidth(15);
        UsuarioActual.getInstancia().factura(modelo);
    }

    private void contenidoLabel() {
        this.jLabelUsuario.setText("Hola, " + UsuarioActual.getInstancia().getUsuario().getNombre());
        this.jLabelProducto.setText(this.jLabelProducto.getText() + " " + UsuarioActual.getInstancia().getUsuario().getCarrito().getSize());
        this.jLabelPrecio.setText(this.jLabelPrecio.getText() + String.format("%.2f", UsuarioActual.getInstancia().getUsuario().getTotal()));
    }

    private void contenidoText() {
        this.jTextFieldTarjeta.setText(UsuarioActual.getInstancia().getUsuario().getTarjeta().numero());
        this.jTextFieldPropietarioTarjeta.setText(UsuarioActual.getInstancia().getUsuario().getTarjeta().getNombre());
    }

    private DefaultTableModel getModelo() {
        return modelo;
    }

    private void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    private boolean creacionPDF() throws Exception {
        JFileChooser dlg = new JFileChooser();
        int option = dlg.showSaveDialog(this);
        String path = "";
        if (JFileChooser.APPROVE_OPTION == option) {
            File f = dlg.getSelectedFile();
            txtGuardar.setText(f.toString());
            path = txtGuardar.getText();
        }
        String contenido = "No." + correlativo + "\n"
                + "Compra en linea\n" + "Nombre: " + jTextFieldNombreFactura.getText()
                + "\n" + "NIT: " + jTextFieldNIT.getText() + "\n"
                + "Cleinte frecuente\n" + "Dirección: " + jTextFieldDireccion.getText()
                + "\n" + "No. tarjeta: " + UsuarioActual.getInstancia().getUsuario().getTarjeta().numeroRecibo() + "\nTotal: Q."
                + UsuarioActual.getInstancia().getUsuario().getTotal();
        if (!path.equalsIgnoreCase("")) {
            try {
                FileOutputStream archivo = new FileOutputStream(path + ".pdf");
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);

                doc.open();
                doc.add(new Paragraph(contenido));

                doc.close();
                JOptionPane.showMessageDialog(null, "PDf correctamente creado");
                Factura nuevaFactura = new Factura(correlativo, jTextFieldNombreFactura.getText(),
                        jTextFieldNIT.getText(), "Freceunte", jTextFieldDireccion.getText(), jTextFieldTarjeta.getText(),
                        UsuarioActual.getInstancia().getUsuario().getTotal(), (ListaCircularDoble<Producto>) UsuarioActual.getInstancia().getUsuario().getCarrito().clonar());
                RegistroFactura.getInstancia().getFactura().push(nuevaFactura);
                correlativo++;

                return true;
            } catch (Exception e) {
            }
        }
        JOptionPane.showMessageDialog(null, "Debe de escoger un nombre");
        return false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPrincipal = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTarjeta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPropietarioTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNombreFactura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNIT = new javax.swing.JTextField();
        jLabelProducto = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jButtonPagar = new javax.swing.JButton();
        txtGuardar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pago de Productos");

        jButtonPrincipal.setText("Pantalla Principal");
        jButtonPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrincipalActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsuario.setText("Usuario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PAGO DE PRODUCTOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tarjeta de crédito");

        jTextFieldTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTarjeta.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de Vencimiento");

        jTextFieldFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFechaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Propietario de la Tarjeta");

        jTextFieldPropietarioTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPropietarioTarjeta.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dirección de entrega");

        jTextFieldDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nombre Factura");

        jTextFieldNombreFactura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNombreFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreFacturaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIT");

        jTextFieldNIT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNITKeyTyped(evt);
            }
        });

        jLabelProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProducto.setText("Productos añadidos:");

        jLabelPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPrecio.setText("Total a pagar Q.");

        jTableProductos.setModel(modelo);
        jScrollPane1.setViewportView(jTableProductos);

        jButtonPagar.setText("Pagar");
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        txtGuardar.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrincipal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPropietarioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelProducto)
                                    .addComponent(jLabelPrecio)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrincipal)
                    .addComponent(jLabelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPropietarioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombreFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPagar)
                    .addComponent(txtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrincipalActionPerformed
        UsuarioPrincipal ventana = new UsuarioPrincipal();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPrincipalActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        if (UsuarioActual.getInstancia().getUsuario().getCarrito().getSize() > 0 && jTextFieldNIT.getText().length() > 0
                && jTextFieldFecha.getText().length() > 0 && jTextFieldNombreFactura.getText().length() > 0 && jTextFieldDireccion.getText().length() > 0) {
            int pagar = JOptionPane.showConfirmDialog(null, "Esta segura de realizar la compra", "Alert", JOptionPane.YES_NO_OPTION);
            try {
                if (JOptionPane.YES_OPTION == pagar && creacionPDF()) {
                    RegistroProducto.getRegistroProducto().ganancias(UsuarioActual.getInstancia().getUsuario());
                    Reporte.getReporte().getUsuario().searchK(UsuarioActual.getInstancia().getUsuario()).setCarrito((ListaCircularDoble<Producto>)UsuarioActual.getInstancia().getUsuario().getCarrito().clonar());
                    UsuarioActual.getInstancia().pagar();
                    UsuarioPrincipal ventana = new UsuarioPrincipal();
                    ventana.setVisible(true);
                    this.dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(VentanaFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonPagarActionPerformed

    private void jTextFieldNITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNITKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && (evt.getKeyChar() != '-' || jTextFieldNIT.getText().contains("-"))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNITKeyTyped

    private void jTextFieldNombreFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreFacturaKeyTyped
        if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNombreFacturaKeyTyped

    private void jTextFieldFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFechaKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '/') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldFechaKeyTyped

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNIT;
    private javax.swing.JTextField jTextFieldNombreFactura;
    private javax.swing.JTextField jTextFieldPropietarioTarjeta;
    private javax.swing.JTextField jTextFieldTarjeta;
    private javax.swing.JTextField txtGuardar;
    // End of variables declaration//GEN-END:variables
}
