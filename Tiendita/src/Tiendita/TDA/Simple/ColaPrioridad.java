package Tiendita.TDA.Simple;

import Tiendita.Objetos.Oferta;

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

    
    public void enqueue(T dato) {
        super.addFin(dato);
    }

    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
        ColaPrioridad<Oferta> cola = new ColaPrioridad<>();
    }

}
