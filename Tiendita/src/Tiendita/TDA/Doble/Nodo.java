package Tiendita.TDA.Doble;

public class Nodo<T> {

    private T dato;
    private Nodo<T> next;
    private Nodo<T> back;

    public Nodo(T dato, Nodo<T> next, Nodo<T> back) {
        this.dato = dato;
        this.next = next;
        this.back = back;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getBack() {
        return back;
    }

    public void setBack(Nodo<T> back) {
        this.back = back;
    }

}
