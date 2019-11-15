package Tiendita.Registros;

import Tiendita.Objetos.Usuario;
import Tiendita.TDA.Simple.ListaSimple;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RegistroUsuario implements Registro<Usuario> {

    private static RegistroUsuario registroUsuario;
    private ListaSimple<Usuario> usuario;

    private RegistroUsuario() {
        usuario = new ListaSimple<>();
    }

    public static RegistroUsuario getRegistroUsuario() {
        if (registroUsuario == null) {
            registroUsuario = new RegistroUsuario();
        }
        return registroUsuario;
    }

    @Override
    public boolean add(Usuario dato) {
        return usuario.compareTo(dato);
    }

    @Override
    public void modify(Usuario dato) {
        try {
            usuario.modify(dato);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Usuario search(Usuario dato) throws Exception {
        try {
            return usuario.searchKey(dato).getDato();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Usuario delete(Usuario dato) throws Exception {
        return usuario.delete(dato);
    }

    @Override
    public void show(DefaultTableModel modelo) {
        Object[] lista = usuario.array();
        for (int i = 0; i < lista.length; i++) {
            Usuario nuevoUsuario = (Usuario) lista[i];
            Object[] datos = new Object[3];
            datos[0] = i + 1;
            datos[1] = nuevoUsuario.getUsuario();
            datos[2] = nuevoUsuario.getNombre();
            modelo.addRow(datos);
        }
    }

    public void showEspecifico(DefaultTableModel modelo, int index) {
        try {
            Usuario nuevo = usuario.search(index);
            Object[] datos = new Object[5];
            datos[0] = nuevo.getUsuario();
            datos[1] = nuevo.getPassword();
            datos[2] = nuevo.getNombre();
            datos[3] = nuevo.getApellido();
            datos[4] = nuevo.getTarjeta().numero();
            modelo.addRow(datos);
        } catch (Exception ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void cargaMasiva(String cadena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean login(Usuario dato) {
        try {
            Usuario usu = usuario.searchKey(dato).getDato();
            if (dato.getUsuario().equalsIgnoreCase(usu.getUsuario()) && dato.getPassword().equals(usu.getPassword())) {
                System.out.println("Bienvenido");
                UsuarioActual.getInstancia().setUsuario(usu);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
