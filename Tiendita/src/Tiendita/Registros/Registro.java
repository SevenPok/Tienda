package Tiendita.Registros;

import javax.swing.table.DefaultTableModel;

public interface Registro<T> {

    public boolean add(T dato);

    public void modify(T dato);

    public T search(T dato) throws Exception;

    public T delete(T dato) throws Exception;

    public void show(DefaultTableModel modelo);

    public void cargaMasiva(String cadena);

}
