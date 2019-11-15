package Tiendita.Registros;

import Tiendita.Objetos.Usuario;

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

}
