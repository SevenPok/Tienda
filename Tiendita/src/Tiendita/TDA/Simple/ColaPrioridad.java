package Tiendita.TDA.Simple;

import Tiendita.Objetos.Oferta;
import Tiendita.Objetos.Producto;

public class ColaPrioridad<T> extends ListaSimple<T> {

    public ColaPrioridad() {
        super();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public T primero() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        }
        return super.getCabeza().getDato();
    }

    public T ultimo() throws Exception {
        return super.peek();
    }

    public T dequeue() throws Exception {
        return super.removeInicio();
    }

    @Override
    public T deleteIndex(int index) throws Exception {
        return super.deleteIndex(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return super.getSize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] array() {
        return super.array();
    }

    public void enqueue(T dato) {
        super.addFin(dato);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public T search(int index) throws Exception {
        return super.search(index); 
    }
    
    

    public static void main(String[] args) {
        ColaPrioridad<Oferta> cola = new ColaPrioridad<>();
        ListaSimple<Producto> simple = new ListaSimple<>();
        ListaSimple<Producto> simple2 = new ListaSimple<>();
        simple.compareTo(new Producto(0, "as", "", 0, 0, ""));
        simple.compareTo(new Producto(4, "", "", 0, 0, ""));
        simple.compareTo(new Producto(5, "gf", "", 0, 0, ""));
        simple.compareTo(new Producto(6, "hj", "", 0, 0, ""));

        simple2.compareTo(new Producto(0, "as", "", 0, 0, ""));
        simple2.compareTo(new Producto(8, "s", "", 0, 0, ""));

        cola.enqueue(new Oferta("", 5, simple2, ""));
        cola.enqueue(new Oferta("", 0, simple, ""));
        Object[] k = cola.array();
        int tamanio = 0;
        for (int i = 0; i < k.length; i++) {
            Object[] l = ((Oferta) k[i]).getLista().array();
            for (int j = 0; j < l.length; j++) {
                tamanio++;
            }
        }
        System.out.println(tamanio);
    }

}
