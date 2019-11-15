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
